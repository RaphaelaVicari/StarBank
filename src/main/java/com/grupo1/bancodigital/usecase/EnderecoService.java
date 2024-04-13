//package com.grupo1.bancodigital.usecase;
//
//import com.grupo1.bancodigital.dto.*;
//import com.grupo1.bancodigital.model.cliente.ClienteEntity;
//import com.grupo1.bancodigital.model.cliente.EnderecoEntity;
//import com.grupo1.bancodigital.dao.ClienteRepository;
//import com.grupo1.bancodigital.dao.EnderecoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Service
//public class EnderecoService {
//
//    @Autowired
//    private EnderecoRepository enderecoRepository;
//
//    @Autowired
//    private ClienteRepository clienteRepository;
//
//    public EnderecoResponse cadastrarEndereco(String cpfCliente, EnderecoRequest enderecoRequest) {
//
//        ClienteEntity clienteEntity = clienteRepository.procurarPorCpf(cpfCliente);
//
//        if (Objects.isNull(clienteEntity)) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CPF inválido!");
//        }
//
//        EnderecoEntity endereco = EnderecoEntity.builder()
//
//                .rua(enderecoRequest.getRua())
//                .numero(enderecoRequest.getNumero())
//                .bairro(enderecoRequest.getBairro())
//                .cidade(enderecoRequest.getCidade())
//                .uf(enderecoRequest.getUf())
//                .cep(enderecoRequest.getCep())
//                .cliente(clienteEntity)
//                .build();
//
//        EnderecoEntity enderecoSalvo = enderecoRepository.save(endereco);
//
//        return mapearEndereco(enderecoSalvo);
//    }
//
//    private static EnderecoResponse mapearEndereco(EnderecoEntity enderecoSalvo) {
//        return EnderecoResponse.builder()
//                .id_endereco(enderecoSalvo.getIdEndereco())
//                .rua(enderecoSalvo.getRua())
//                .numero(enderecoSalvo.getNumero())
//                .bairro(enderecoSalvo.getBairro())
//                .cidade(enderecoSalvo.getCidade())
//                .uf(enderecoSalvo.getUf())
//                .cep(enderecoSalvo.getCep())
//                .build();
//    }
//
//    public EnderecoResponse procurarEnderecoPorCep(Long idEndereco) {
//        EnderecoEntity enderecoEncontrado = enderecoRepository.procurarPorId((idEndereco));
//
//        if (Objects.isNull(enderecoEncontrado)) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");
//        }
//
//        return mapearEndereco(enderecoEncontrado);
//    }
//
//    public List<EnderecoResponse> listarEndereco(String cpfCliente) {
//        List<EnderecoEntity> enderecoEncontrado = enderecoRepository.procurarPorCpf(cpfCliente);
//        List<EnderecoResponse> enderecoResponse = new ArrayList<>();
//
//        for (EnderecoEntity i : enderecoEncontrado) {
//            enderecoResponse.add(mapearEndereco(i));
//        }
//
//        return enderecoResponse;
//    }
//
//    public EnderecoResponse atualizarEndereco(long idEndereco, EnderecoRequest enderecoRequest) {
//        EnderecoEntity enderecoExistente = enderecoRepository.procurarPorId((idEndereco));
//
//        if (Objects.isNull(enderecoExistente)) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");
//        }
//
//        enderecoExistente = enderecoExistente.toBuilder()
//                .rua(enderecoRequest.getRua())
//                .numero(enderecoRequest.getNumero())
//                .bairro(enderecoRequest.getBairro())
//                .cidade(enderecoRequest.getCidade())
//                .uf(enderecoRequest.getUf())
//                .cep(enderecoRequest.getCep())
//                .build();
//
//        EnderecoEntity enderecoAtualizado = enderecoRepository.save(enderecoExistente);
//
//        return mapearEndereco(enderecoAtualizado);
//    }
//}
