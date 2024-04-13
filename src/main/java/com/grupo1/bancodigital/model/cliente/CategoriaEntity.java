package com.grupo1.bancodigital.model.cliente;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CategoriaEntity implements Serializable {

    private Integer idCategoria;

    private String nomeCategoria;

//    private List<ClienteEntity> clientes;

}