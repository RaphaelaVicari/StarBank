package com.grupo1.bancodigital.entity.conta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "conta_corrente")
public class ContaCorrenteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta_corrente", nullable = false)
    private Long idContaCorrente;

    @Column(name = "saldo")
    private Double saldo;

    @Column(name = "taxa_manutencao")
    private Double taxaManuntencao;

    @OneToOne
    @JoinColumn(name = "fk_id_conta", referencedColumnName = "id_conta")
    private ContaEntity conta;

}
