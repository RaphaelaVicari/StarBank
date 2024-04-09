package com.grupo1.bancodigital.controller;

import com.grupo1.bancodigital.dto.CartaoRequest;
import com.grupo1.bancodigital.dto.CartaoResponse;
import com.grupo1.bancodigital.dto.ClienteRequest;
import com.grupo1.bancodigital.dto.ClienteResponse;
import com.grupo1.bancodigital.model.cartao.CartaoEntity;
import com.grupo1.bancodigital.usecase.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartaoController {
    @Autowired
    private CartaoService cartaoService;




}
