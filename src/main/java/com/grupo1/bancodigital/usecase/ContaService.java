package com.grupo1.bancodigital.usecase;

import com.grupo1.bancodigital.dao.ClienteRepository;
import com.grupo1.bancodigital.dao.ContaPoupancaRepository;
import com.grupo1.bancodigital.dao.ContaRepository;
import com.grupo1.bancodigital.dao.TipoContaRepository;
import com.grupo1.bancodigital.dto.ContaRequest;
import com.grupo1.bancodigital.dto.ContaResponse;
import com.grupo1.bancodigital.dto.TipoContaEnum;
import com.grupo1.bancodigital.model.cliente.ClienteEntity;
import com.grupo1.bancodigital.model.conta.ContaEntity;
import com.grupo1.bancodigital.model.conta.ContaPoupancaEntity;
import com.grupo1.bancodigital.model.conta.TipoContaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    private ContaRepository contaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TipoContaRepository tipoContaRepository;

    public ContaResponse cadastrarContaCorrent(String cpf, ContaRequest conta) {
        return null;
    }


    public ContaResponse cadastrarContaPoupanca(String cpf, TipoContaEnum tipoConta, ContaRequest conta) {
        ClienteEntity clienteEntity = clienteRepository.procurarPorCpf(cpf);
        if (clienteEntity == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado!");
        }

        TipoContaEntity tipoContaEntity = tipoContaRepository.findByNomeTipoConta(tipoConta.name());
        if (tipoContaEntity == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo da conta não encontrado!");
        }


        ContaEntity contaEntity = ContaEntity.builder()
                .numeroConta(conta.getNumeroConta())
                .numeroAgencia(conta.getNumeroAgencia())
                .digitoConta(conta.getDigitoConta().longValue())
                .senha(conta.getSenha())
                .tipoConta(tipoContaEntity)
                .build();

        ContaEntity contaSalvada = contaRepository.save(contaEntity);

        ContaPoupancaEntity contapoupanca = ContaPoupancaEntity.builder()
                .saldo(conta.getSaldo())
                .taxaRendimento(10d)//todo fazer swith case com a categoria do cliente para retornar a taxa de redimento
                .conta(contaSalvada)
                .build();

        ContaPoupancaEntity contaPoupancaSalvo = contaPoupancaRepository.save(contapoupanca);

        return mapearContaPoupanca(contaSalvada,
                contaPoupancaSalvo.getSaldo(),
                contaPoupancaSalvo.getTaxaRendimento(),
                null);
    }

    private static ContaResponse mapearContaPoupanca(ContaEntity contaEntity,
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

        return mapearContaPoupanca(contaPoupancaEncontrada.getConta(),
                contaPoupancaEncontrada.getSaldo(),
                contaPoupancaEncontrada.getTaxaRendimento(),
                null);
    }

    public List<ContaResponse> listarConta(String cpfCliente) {
        List<ContaPoupancaEntity> contaPoupancaEncontrada = contaPoupancaRepository.procurarPorCpf(cpfCliente);

        List<ContaResponse> contaPoupancaResponse = new ArrayList<>();

        for (ContaPoupancaEntity i : contaPoupancaEncontrada) {
            contaPoupancaResponse.add(mapearContaPoupanca(i.getConta(),
                    i.getSaldo(),
                    i.getTaxaRendimento(),
                    null));
        }

        return contaPoupancaResponse;
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
