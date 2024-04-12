package com.grupo1.bancodigital.usecase;

import com.grupo1.bancodigital.dao.*;
import com.grupo1.bancodigital.dto.ContaRequest;
import com.grupo1.bancodigital.dto.ContaResponse;
import com.grupo1.bancodigital.dto.TipoContaEnum;
import com.grupo1.bancodigital.model.cliente.CategoriaEntity;
import com.grupo1.bancodigital.model.cliente.ClienteEntity;
import com.grupo1.bancodigital.model.conta.ContaCorrenteEntity;
import com.grupo1.bancodigital.model.conta.ContaEntity;
import com.grupo1.bancodigital.model.conta.ContaPoupancaEntity;
import com.grupo1.bancodigital.model.conta.TipoContaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class ContaService {

    @Autowired
    private ContaPoupancaRepository contaPoupancaRepository;
    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TipoContaRepository tipoContaRepository;

    public ContaResponse cadastrarContaCorrente(String cpf, TipoContaEnum tipoConta, ContaRequest conta) {
        ClienteEntity clienteEntity = clienteRepository.procurarPorCpf(cpf);
        if (clienteEntity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!");
        }

        TipoContaEntity tipoContaEntity = tipoContaRepository.findByNomeTipoConta(tipoConta.name());
        if (tipoContaEntity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo da conta não encontrado!");
        }


        ContaEntity contaEntity = ContaEntity.builder()
                .numeroConta(randomCardNumberGenerator(5))
                .digitoConta(Long.valueOf(randomCardNumberGenerator(1)))
                .numeroAgencia(randomCardNumberGenerator(4))
                .senha(randomCardNumberGenerator(6))
                .tipoConta(tipoContaEntity)
                .build();

        ContaEntity contaSalvada = contaRepository.save(contaEntity);

        ContaCorrenteEntity contaCorrente = ContaCorrenteEntity.builder()
                .saldo(0d)
                .taxaManuntencao(tipoContaTaxaController(tipoConta, clienteEntity.getCategoria()))
                .conta(contaSalvada)
                .build();

        ContaCorrenteEntity contaCorrenteSalvo = contaCorrenteRepository.save(contaCorrente);

        return mapearConta(contaSalvada,
                contaCorrenteSalvo.getSaldo(),
                null,
                contaCorrenteSalvo.getTaxaManuntencao());
    }


    public ContaResponse cadastrarContaPoupanca(String cpf, TipoContaEnum tipoConta, ContaRequest conta) {
        ClienteEntity clienteEntity = clienteRepository.procurarPorCpf(cpf);
        if (clienteEntity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!");
        }

        TipoContaEntity tipoContaEntity = tipoContaRepository.findByNomeTipoConta(tipoConta.name());
        if (tipoContaEntity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo da conta não encontrado!");
        }


        ContaEntity contaEntity = ContaEntity.builder()
                .numeroConta(randomCardNumberGenerator(5))
                .digitoConta(Long.valueOf(randomCardNumberGenerator(1)))
                .numeroAgencia(randomCardNumberGenerator(4))
                .senha(randomCardNumberGenerator(4))
                .tipoConta(tipoContaEntity)
                .build();

        ContaEntity contaSalvada = contaRepository.save(contaEntity);

        ContaPoupancaEntity contapoupanca = ContaPoupancaEntity.builder()
                .saldo(0d)
                .taxaRendimento(tipoContaTaxaController(tipoConta, clienteEntity.getCategoria()))
                .conta(contaSalvada)
                .build();

        ContaPoupancaEntity contaPoupancaSalvo = contaPoupancaRepository.save(contapoupanca);

        return mapearConta(contaSalvada,
                contaPoupancaSalvo.getSaldo(),
                contaPoupancaSalvo.getTaxaRendimento(),
                null);
    }

    private Double tipoContaTaxaController(TipoContaEnum tipoConta, CategoriaEntity categoria) {
        double contaTaxa = 0;
        switch (tipoConta) {
            case CORRENTE:
                contaTaxa = taxaCorrenteController(categoria);
                break;
            case POUPANCA:
                contaTaxa = taxaPoupancaController(categoria);
                break;
        }

        return contaTaxa;
    }

    private Double taxaPoupancaController(CategoriaEntity categoria) {
        double taxaMensal = 0;
        switch (categoria.getNomeCategoria()) {

            case "SUPER":
                taxaMensal = 0.007;
                break;
            case "COMUM":
                taxaMensal = 0.005;
                break;
            case "PREMIUM":
                taxaMensal = 0.009;
                break;

        }
        return taxaMensal;
    }

    private Double taxaCorrenteController(CategoriaEntity categoria) {
        double taxaManutencao = 0;
        switch (categoria.getNomeCategoria()) {
            case "SUPER":
                taxaManutencao = 12.00;
                break;
            case "COMUM":
                taxaManutencao = 8.00;
                break;
            case "PREMIUM":
                taxaManutencao = 0;
                break;
        }
        return taxaManutencao;
    }

    private static ContaResponse mapearConta(ContaEntity contaEntity,
                                             Double saldo,
                                             Double txRendi,
                                             Double txManu) {
        return ContaResponse.builder()
                .idConta(contaEntity.getIdConta())
                .numeroConta(contaEntity.getNumeroConta())
                .numeroAgencia(contaEntity.getNumeroAgencia())
                .digitoConta(contaEntity.getDigitoConta().intValue())
                .senha(contaEntity.getSenha())
                .saldo(saldo)
                .taxaRendimento(txRendi)
                .taxaManutencao(txManu)
                .conta(TipoContaEnum.valueOf(contaEntity.getTipoConta().getNomeTipoConta()))
                .build();
    }

    public ContaResponse procurarContaPoupancaPorCpf(Long idContaPoupanca) {
        ContaPoupancaEntity contaPoupancaEncontrada = contaPoupancaRepository.procurarPorId((idContaPoupanca));

        if (Objects.isNull(contaPoupancaEncontrada)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");
        }

        return mapearConta(contaPoupancaEncontrada.getConta(),
                contaPoupancaEncontrada.getSaldo(),
                contaPoupancaEncontrada.getTaxaRendimento(),
                null);
    }

    public ContaResponse procurarContaCorrentePorCpf(Long idContaCorrente) {
        ContaCorrenteEntity contaCorrenteEncontrada = contaCorrenteRepository.procurarPorId((idContaCorrente));

        if (Objects.isNull(contaCorrenteEncontrada)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");
        }

        return mapearConta(contaCorrenteEncontrada.getConta(),
                contaCorrenteEncontrada.getSaldo(),
                contaCorrenteEncontrada.getTaxaManuntencao(),
                null);
    }

    public List<ContaResponse> listarConta(String cpfCliente) {
        List<ContaPoupancaEntity> contaPoupancaEncontrada = contaPoupancaRepository.procurarPorCpf(cpfCliente);
        List<ContaCorrenteEntity> contaCorrenteEncontrada = contaCorrenteRepository.procurarPorCpf(cpfCliente);

        //todo implementar procurar por cpf contas correntes na conta corrente repository, que retorna uma lista de conta corrente entity
        List<ContaResponse> contaResponse = new ArrayList<>();


        for (ContaPoupancaEntity i : contaPoupancaEncontrada) {
            contaResponse.add(mapearConta(i.getConta(),
                    i.getSaldo(),
                    i.getTaxaRendimento(),
                    null));
        }


        for (ContaCorrenteEntity i : contaCorrenteEncontrada) {
            contaResponse.add(mapearConta(i.getConta(),
                    i.getSaldo(),
                    null,
                    i.getTaxaManuntencao()));
        }


        //todo fazer um for percorrendo a lista de contas correntes encontradas no banco de dados
        return contaResponse;
    }

    private static String randomCardNumberGenerator(int howManyNumbers) {
        Random random = new Random();
        StringBuilder numeroCartao = new StringBuilder();
        for (int i = 0; i < howManyNumbers; i++) {

            int digito = random.nextInt(10);
            numeroCartao.append(digito);
        }
        return numeroCartao.toString();
    }


}
