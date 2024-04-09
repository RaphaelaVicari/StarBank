package com.grupo1.bancodigital.entity.seguro;

import com.grupo1.bancodigital.entity.cartao.CartaoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seguro")
public class SeguroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seguro", nullable = false)
    private Long idSeguro;

    @Column(name = "numero_apolice",nullable = false)
    private String numeroApolice;

    @Column(name = "descricao_cobertura",nullable = false)
    private String descricaoCobertura;

    @Column(name = "valor_seguro",nullable = false)
    private Long valorSeguro;

    @Column(name = "valor_indenizacao",nullable = false)
    private Long valorIndenizacao;

    @Column(name = "data_contratacao",nullable = false)
    private LocalDate dataContratacao;

    @Column(name = "inicio_vigencia",nullable = false)
    private LocalDate inicioVigencia;

    @Column(name = "fim_vigencia",nullable = false)
    private LocalDate fimVigencia;

    @ManyToOne
    @JoinColumn(name = "fk_id_cartao", referencedColumnName = "id_cartao")
    private CartaoEntity cartao;

}
