package com.grupo1.bancodigital.controller;

import com.grupo1.bancodigital.dto.ClienteRequest;
import com.grupo1.bancodigital.dto.ClienteResponse;
import com.grupo1.bancodigital.usecase.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/api/cliente")
    @ResponseBody
    public ResponseEntity<ClienteResponse> postCliente(@RequestBody ClienteRequest cliente) {
        ClienteResponse response = clienteService.cadastrarNovoCliente(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/api/cliente/{cpfCliente}")
    public ClienteResponse getCliente(@PathVariable("cpfCliente") String cpfCliente) {
        ClienteResponse response = clienteService.procurarClientePorCpf(cpfCliente);
        return response;
    }

    @GetMapping("/api/cliente")
    public List<ClienteResponse> getCliente() {
        List<ClienteResponse> response = clienteService.listarClientes();
        return response;
    }

    @PutMapping("/api/cliente/{cpfCliente}")
    public ClienteResponse atualizarCliente(@PathVariable("cpfCliente") String cpfCliente,
                                            @RequestBody ClienteRequest cliente) {
        ClienteResponse response = clienteService.atualizarCliente(cpfCliente, cliente);
        return response;
    }

}
