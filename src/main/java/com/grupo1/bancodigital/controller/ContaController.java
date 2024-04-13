//package com.grupo1.bancodigital.controller;
//
//import com.grupo1.bancodigital.dto.*;
//import com.grupo1.bancodigital.usecase.CartaoService;
//import com.grupo1.bancodigital.usecase.ContaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class ContaController {
//    @Autowired
//    private ContaService contaService;
//
//
//    @PostMapping("/api/cliente/{cpf}/conta")
//    @ResponseBody
//    public ResponseEntity<ContaResponse> postConta(@RequestParam("tipoConta") TipoContaEnum key,
//                                                   @RequestBody ContaRequest conta,
//                                                   @PathVariable("cpf") String cpf) {
//
//        if (key.equals(TipoContaEnum.CORRENTE)) {
//            ContaResponse response = contaService.cadastrarContaCorrente(cpf, key, conta);
//            return ResponseEntity.status(HttpStatus.CREATED).body(response);
//        } else if (key.equals(TipoContaEnum.POUPANCA)) {
//            ContaResponse response = contaService.cadastrarContaPoupanca(cpf, key, conta);
//            return ResponseEntity.status(HttpStatus.CREATED).body(response);
//        } else {
//            // Parâmetro 'key' inválido
//            return ResponseEntity.badRequest().body(null);
//        }
//
//
//    }
//
//    //todo endpoint de detalhe
//   //  @GetMapping("/api/conta")
//
//
//    //todo listar contas
//    @GetMapping("/api/cliente/{cpf}/conta")
//    public List<ContaResponse> getContas(@PathVariable("cpf") String cpf) {
//        List<ContaResponse> response = contaService.listarConta(cpf);
//        return response;
//    }
//}
//
