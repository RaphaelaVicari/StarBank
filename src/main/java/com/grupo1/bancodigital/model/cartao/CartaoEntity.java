//package com.grupo1.bancodigital.model.cartao;
//
//import com.grupo1.bancodigital.model.conta.ContaEntity;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDate;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "cartao")
//@Builder(toBuilder = true)
//public class CartaoEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_cartao",nullable = false)
//    private Long idCartao;
//
//    @ManyToOne
//    @JoinColumn(name = "fk_id_conta",referencedColumnName = "id_conta")
//    private ContaEntity conta;
//
//    @ManyToOne
//    @JoinColumn(name = "fk_id_tipo_cartao", referencedColumnName = "id_tipo_cartao")
//    private TipoCartaoEntity tipoCartao;
//
//    @Column(name = "numero_cartao",nullable = false)
//    private String numeroCartao;
//
//    @Column(name = "senha",nullable = false)
//    private String senha;
//
//    @Column(name = "cvv_cartao",nullable = false)
//    private String cvv;
//
//    @Column(name = "valor_limite")
//    private Double limite;
//
//    @Column(name = "data_vencimento")
//    private LocalDate dataVencimento;
//
//
//}
