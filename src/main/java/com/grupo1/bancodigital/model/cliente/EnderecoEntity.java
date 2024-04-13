//package com.grupo1.bancodigital.model.cliente;
//
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.io.Serializable;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "endereco")
//@Builder(toBuilder = true)
//public class EnderecoEntity implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_endereco", nullable = false)
//    private Long idEndereco;
//
//    @Column(name = "rua")
//    private String rua;
//
//    @Column(name = "numero")
//    private String numero;
//
//    @Column(name = "bairro")
//    private String bairro;
//
//    @Column(name = "cidade")
//    private String cidade;
//
//    @Column(name = "uf")
//    private String uf;
//
//    @Column(name = "cep")
//    private String cep;
//
//    @ManyToOne
//    @JoinColumn(name = "fk_cpf_cliente", referencedColumnName = "cpf")
//    private ClienteEntity cliente;
//
//}
