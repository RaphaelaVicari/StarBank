//package com.grupo1.bancodigital.controller;
//
//import com.grupo1.bancodigital.dto.*;
//import com.grupo1.bancodigital.usecase.CartaoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class CartaoController {
//
//    @Autowired
//    CartaoService cartaoService;
//
//    //criar Cartao (Credito ou Debito)
//    @PostMapping("/api/cliente/{cpf}/conta/cartao")
//    @ResponseBody
//    public ResponseEntity<CartaoResponse> postcartao(@RequestParam("tipoCartao") TipoCartaoEnum key,
//                                                     @RequestBody CartaoRequest cartao,
//                                                     @PathVariable("cpf") String cpf) {
//
//        if (key.equals(TipoCartaoEnum.CREDITO)) {
//            CartaoResponse response = cartaoService.cadastrarCartaoCredito(cpf, key, cartao);
//            return ResponseEntity.status(HttpStatus.CREATED).body(response);
//        } else if (key.equals(TipoCartaoEnum.DEBITO)) {
//            CartaoResponse response = cartaoService.cadastrarCartaoDebito(cpf, key, cartao);
//            return ResponseEntity.status(HttpStatus.CREATED).body(response);
//        } else {
//            // Parâmetro 'key' inválidoe
//            return ResponseEntity.badRequest().body(null);
//        }
//
//
//    }
//}
