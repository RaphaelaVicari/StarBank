package com.grupo1.bancodigital.usecase;

import com.grupo1.bancodigital.dto.CartaoRequest;
import com.grupo1.bancodigital.dto.CartaoResponse;
import com.grupo1.bancodigital.dto.ContaResponse;
import com.grupo1.bancodigital.dto.TipoCartaoEnum;
import com.grupo1.bancodigital.model.cartao.CartaoEntity;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {


    public static CartaoResponse cadastrarCartao(CartaoRequest cartao) {


    return null;
    }


    public CartaoResponse cadastrarCartaoCredito(String cpf, TipoCartaoEnum key, CartaoRequest cartao) {
        return null;
    }

    public CartaoResponse cadastrarCartaoDebito(String cpf, TipoCartaoEnum key, CartaoRequest cartao) {
        return  null;
    }
}
