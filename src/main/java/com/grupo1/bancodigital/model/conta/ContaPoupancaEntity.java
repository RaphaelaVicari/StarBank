package com.grupo1.bancodigital.model.conta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "conta_poupanca")
public class ContaPoupancaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta_poupanca", nullable = false)
    private Long idContaPoupanca;

    @Column(name = "saldo")
    private Double saldo;

    @Column(name = "taxa_rendimento")
    private Double taxaManuntencao;

    @OneToOne
    @JoinColumn(name = "fk_id_conta", referencedColumnName = "id_conta")
    private ContaEntity conta;

}
