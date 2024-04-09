package com.grupo1.bancodigital.model.cliente;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoria")
@Builder(toBuilder = true)
public class CategoriaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria", nullable = false)
    private Long idCategoria;

    @Column(name = "nome_categoria")
    private String nomeCategoria;

    @OneToMany(mappedBy = "categoria")
    private List<ClienteEntity> clientes;

}