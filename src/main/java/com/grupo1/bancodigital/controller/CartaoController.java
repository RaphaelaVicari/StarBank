package com.grupo1.bancodigital.controller;

import com.grupo1.bancodigital.dto.*;
import com.grupo1.bancodigital.model.cartao.CartaoEntity;
import com.grupo1.bancodigital.usecase.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartaoController {
    @Autowired
    private CartaoService cartaoService;

    private String tipoCartao;

    @PostMapping("/api/cliente/{cpf}/conta")
    @ResponseBody
    public ResponseEntity<CartaoResponse> postCartao(@RequestParam("key") String key,
    @RequestBody CartaoRequest cartao)   {

        if ("CREDITO".equals(key)) {
            CartaoResponse response = CartaoService.cadastrarCartao(cartao);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else if ("DEBITO".equals(key)) {
            CartaoResponse response = CartaoService.cadastrarCartao(cartao);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            // Parâmetro 'key' inválido
            return  null;
        }


    }
}

