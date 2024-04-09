package com.grupo1.bancodigital.resource;


import com.grupo1.bancodigital.dto.EnderecoRequest;
import com.grupo1.bancodigital.dto.EnderecoResponse;
import com.grupo1.bancodigital.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnderecoResource {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/api/cliente/{cpfCliente}/endereco")
    @ResponseBody
    public ResponseEntity<EnderecoResponse> postEndereco(@PathVariable("cpfCliente") String cpfCliente,
                                                         @RequestBody EnderecoRequest endereco) {
        EnderecoResponse response = enderecoService.cadastrarEndereco(cpfCliente, endereco);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/api/endereco/{id_endereco}")
    public EnderecoResponse getId_endereco(@PathVariable("id_endereco") Long idEndereco) {
        EnderecoResponse response = enderecoService.procurarEnderecoPorCep(idEndereco);
        return response;
    }

    @GetMapping("/api/cliente/{cpfCliente}/endereco")
    public List<EnderecoResponse> getEndereco(@PathVariable("cpfCliente") String cpfCliente) {
        List<EnderecoResponse> response = enderecoService.listarEndereco(cpfCliente);
        return response;
    }

    @PutMapping("/api/endereco/{id_endereco}")
    public EnderecoResponse atualizarEndereco(@PathVariable("id_endereco") Long idEndereco,
                                            @RequestBody EnderecoRequest endereco) {
        EnderecoResponse response = enderecoService.atualizarEndereco(idEndereco, endereco);
        return response;
    }
}
