package com.grupo1.bancodigital.usecase;

import com.grupo1.bancodigital.dao.CartaoRespository;
import com.grupo1.bancodigital.dao.ClienteRepository;
import com.grupo1.bancodigital.dao.TipoCartaoRepository;
import com.grupo1.bancodigital.dto.*;
import com.grupo1.bancodigital.model.cartao.CartaoEntity;
import com.grupo1.bancodigital.model.cartao.TipoCartaoEntity;
import com.grupo1.bancodigital.model.cliente.CategoriaEntity;
import com.grupo1.bancodigital.model.cliente.ClienteEntity;
import com.grupo1.bancodigital.model.conta.ContaCorrenteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Random;

@Service
public class CartaoService {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    TipoCartaoRepository tipoCartaoRepository;
    @Autowired
    CartaoRespository cartaoRespository;


    public static CartaoResponse cadastrarCartao(CartaoRequest cartao) {


        return null;
    }


    public CartaoResponse cadastrarCartaoCredito(String cpf, TipoCartaoEnum tipoCartao, CartaoRequest cartao) {
        ClienteEntity clienteEntity = clienteRepository.procurarPorCpf(cpf);
        if (clienteEntity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!");
        }

        TipoCartaoEntity tipoCartaoEntity = tipoCartaoRepository.findByNomeTipo(tipoCartao.name());
        if (tipoCartaoEntity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo Cartao não encontrado!");
        }


        CartaoEntity cartaoEntity = CartaoEntity.builder()
                .numeroCartao(randomCardNumberGenerator(16))
                .senha(randomCardNumberGenerator(4))
                .cvv(randomCardNumberGenerator(3))
                .limite(cartaoLimiteController(tipoCartao, clienteEntity.getCategoria()))
                .dataVencimento(LocalDate.now().plusYears(10))
                .tipoCartao(tipoCartaoEntity)
                .build();

        CartaoEntity cartaoSalvo = cartaoRespository.save(cartaoEntity);

        return mapearCartao(cartaoSalvo);
    }

    private CartaoResponse mapearCartao(CartaoEntity cartaoEntity) {
        return CartaoResponse.builder()
                .idCartao(cartaoEntity.getIdCartao())
                .numeroCartao(Long.valueOf(cartaoEntity.getNumeroCartao()))
                .dataVencimento(cartaoEntity.getDataVencimento())
                .cvv(Long.valueOf(cartaoEntity.getCvv()))
                .limite(cartaoEntity.getLimite())
                .tipoCartao(TipoCartaoEnum.valueOf(cartaoEntity.getTipoCartao().getNomeTipo()))
                .senha(cartaoEntity.getSenha())
                .build();
    }

    private Double cartaoLimiteController(TipoCartaoEnum tipoCartao, CategoriaEntity categoria) {
        double valorLimite = 0;
        switch (tipoCartao) {
            case CREDITO:
                valorLimite = valorLimiteCredito(categoria);
                break;
            case DEBITO:
                valorLimite = valorLimiteDebito(categoria);
                i
                break;

        }
        return valorLimite;

    }

    private double valorLimiteCredito(CategoriaEntity categoria) {
        double valorLimite = 0;
        switch (categoria.getNomeCategoria()) {
            case "SUPER":
                valorLimite = 5000d;
                break;
            case "PREMIUM":
                valorLimite = 10000d;
                break;
            case "COMUM":
                valorLimite = 1000d;
                break;
        }
        return valorLimite;
    }

    private double valorLimiteDebito(CategoriaEntity categoria) {
        double valorLimite = 0;
        switch (categoria.getNomeCategoria()) {
            case "SUPER":
                valorLimite = 5000d;
                break;
            case "PREMIUM":
                valorLimite = 10000d;
                break;
            case "COMUM":
                valorLimite = 1000d;
                break;
        }
        return valorLimite;
    }

    public CartaoResponse cadastrarCartaoDebito(String cpf, TipoCartaoEnum key, CartaoRequest cartao) {
        return null;
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
