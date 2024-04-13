//package com.grupo1.bancodigital.model.transferencia;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.io.Serializable;
//import java.util.List;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "tipo_transferencia")
//@Builder(toBuilder = true)
//public class TipoTransferenciaEntity implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_tipo_transferencia", nullable = false)
//    private Long idTipoTransfernecia;
//
//    @Column(name = "nome_transferencia")
//    private String nomeTransferencia;
//
//    @OneToMany(mappedBy = "tipoTransferencia")
//    private List<TransferenciaEntity> transferencias;
//}
