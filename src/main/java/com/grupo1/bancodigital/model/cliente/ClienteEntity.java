package com.grupo1.bancodigital.model.cliente;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ClienteEntity implements Serializable {

    private String cpf;

    private String nomeCliente;

    private LocalDate dataNascimento;

    private Integer categoria;

//    private CategoriaEntity categoria;

//    private List<EnderecoEntity> endereco;

//    private ContaEntity conta;

}
