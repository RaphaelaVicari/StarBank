package com.grupo1.bancodigital.model.conta;


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
@Table(name = "tipo_conta")
@Builder(toBuilder = true)
public class TipoContaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_conta", nullable = false)
    private Long idTipoConta;

    @Column(name = "nome_tipo_conta")
    private String nomeTipoConta;

    @OneToMany(mappedBy = "tipoConta")
    private List<ContaEntity> contas;

}
