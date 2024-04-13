//package com.grupo1.bancodigital.model.transferencia;
//
//import com.grupo1.bancodigital.model.conta.ContaEntity;
//import com.grupo1.bancodigital.model.conta.TipoContaEntity;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "transferencia")
//public class TransferenciaEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_transferencia", nullable = false)
//    private Long idTransferencia;
//
//    @ManyToOne
//    @JoinColumn(name = "fk_id_conta_origem", referencedColumnName = "id_conta")
//    private ContaEntity contaOrigem;
//
//    @ManyToOne
//    @JoinColumn(name = "fk_id_conta_destino", referencedColumnName = "id_conta")
//    private ContaEntity contaDestino;
//
//    @Column(name = "valor_transferido", nullable = false)
//    private Double valorTransferido;
//
//    @ManyToOne
//    @JoinColumn(name = "fk_tipo_conta_origem", referencedColumnName = "id_tipo_conta")
//    private TipoContaEntity tipoContaOrigem;
//
//    @ManyToOne
//    @JoinColumn(name = "fk_tipo_conta_destino", referencedColumnName = "id_tipo_conta")
//    private TipoContaEntity tipoContaDestino;
//
//    @ManyToOne
//    @JoinColumn(name = "fk_tipo_transferencia", referencedColumnName = "id_tipo_transferencia")
//    private TipoTransferenciaEntity tipoTransferencia;
//
//
//}
