package com.grupo1.bancodigital.controller;

import com.grupo1.bancodigital.dto.*;
import com.grupo1.bancodigital.usecase.CartaoService;
import com.grupo1.bancodigital.usecase.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContaController {
    @Autowired
    private ContaService contaService;


    @PostMapping("/api/cliente/{cpf}/conta")
    @ResponseBody
    public ResponseEntity<ContaResponse> postConta(@RequestParam("tipoConta") TipoContaEnum key,
                                                   @RequestBody ContaRequest conta,
                                                   @PathVariable("cpf") String cpf) {

        if (key.equals(TipoContaEnum.CORRENTE)) {
            ContaResponse response = contaService.cadastrarContaCorrent(cpf, conta);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else if (key.equals(TipoContaEnum.POUPANCA)) {
            ContaResponse response = contaService.cadastrarContaPoupanca(cpf, conta);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            // Parâmetro 'key' inválido
            return ResponseEntity.badRequest().body(null);
        }


    }


}

