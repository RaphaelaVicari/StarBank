package com.grupo1.bancodigital.usecase;

import com.grupo1.bancodigital.dto.CategoriaEnum;
import com.grupo1.bancodigital.dto.ClienteRequest;
import com.grupo1.bancodigital.dto.ClienteResponse;
import com.grupo1.bancodigital.model.cliente.CategoriaEntity;
import com.grupo1.bancodigital.model.cliente.ClienteEntity;
import com.grupo1.bancodigital.dao.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CategoriaService categoriaService;

    public ClienteResponse cadastrarNovoCliente(ClienteRequest clienteRequest) {

        if (clienteRequest.getCpf().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria Invalida");
        }

        CategoriaEntity categoriaEntity = categoriaService.procurarCategoriaPorNome(clienteRequest.getCategoria());

        if (Objects.isNull(categoriaEntity)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria Invalida");
        }

        ClienteEntity cliente = ClienteEntity.builder()
                .nomeCliente(clienteRequest.getNome())
                .cpf(clienteRequest.getCpf())
                .dataNascimento(clienteRequest.getDataNascimento())
                .categoria(categoriaEntity.getIdCategoria())
                .build();

        ClienteEntity clienteSalvo = clienteRepository.save(cliente);

        return mapearCliente(CategoriaEnum.valueOf(categoriaEntity.getNomeCategoria()), clienteSalvo);
    }

    private static ClienteResponse mapearCliente(CategoriaEnum categoria, ClienteEntity clienteSalvo) {
        return ClienteResponse.builder()
                .nome(clienteSalvo.getNomeCliente())
                .categoria(categoria)
                .cpf(clienteSalvo.getCpf())
                .dataNascimento(clienteSalvo.getDataNascimento())
                .build();
    }


    public ClienteResponse procurarClientePorCpf(String cpfCliente) {

        ClienteEntity clienteEncontrado = clienteRepository.procurarPorCpf(cpfCliente);

        if (Objects.isNull(clienteEncontrado)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }

        CategoriaEntity categoria = categoriaService.procurarCategoriaPorId(clienteEncontrado.getCategoria());

        return mapearCliente(CategoriaEnum.valueOf(categoria.getNomeCategoria()),
                clienteEncontrado);
    }

    public List<ClienteResponse> listarClientes() {
        List<ClienteEntity> clientesEncontrados = clienteRepository.findAll();
        List<ClienteResponse> clienteResponse = new ArrayList<>();

        for(ClienteEntity i : clientesEncontrados) {

            CategoriaEntity categoria = categoriaService.procurarCategoriaPorId(i.getCategoria());

            ClienteResponse clienteMapeado = mapearCliente(CategoriaEnum.valueOf(categoria.getNomeCategoria()), i);
            clienteResponse.add(clienteMapeado);
        }

        return clienteResponse;
    }

    public ClienteResponse atualizarCliente(String cpfCliente, ClienteRequest cliente) {

        ClienteEntity clienteExistente = clienteRepository.procurarPorCpf(cpfCliente);

        if (Objects.isNull(clienteExistente)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }

        clienteExistente.setNomeCliente(cliente.getNome());
        clienteExistente.setDataNascimento(cliente.getDataNascimento());

        CategoriaEntity categoriaEntity = categoriaService.procurarCategoriaPorNome(cliente.getCategoria());

        if (Objects.isNull(categoriaEntity)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria Inválida");
        }

        clienteExistente.setCategoria(categoriaEntity.getIdCategoria());

        ClienteEntity clienteAtualizado = clienteRepository.update(clienteExistente);

        return mapearCliente(CategoriaEnum.valueOf(categoriaEntity.getNomeCategoria()), clienteAtualizado);
    }

}