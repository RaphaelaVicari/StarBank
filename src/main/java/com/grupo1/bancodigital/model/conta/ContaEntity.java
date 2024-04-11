package com.grupo1.bancodigital.model.conta;

import com.grupo1.bancodigital.model.cliente.ClienteEntity;
import com.grupo1.bancodigital.model.transferencia.TransferenciaEntity;
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
@Table(name = "conta")
@Builder(toBuilder = true)
public class ContaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta", nullable = false)
    private Long idConta;

    @Column(name = "numero_conta", nullable = false)
    private String numeroConta;

    @Column(name = "numero_agencia", nullable = false)
    private String numeroAgencia;

    @Column(name = "digito_conta", nullable = false)
    private Long digitoConta;

    @Column(name = "senha", nullable = false)
    private String senha;

    @OneToOne
    @JoinColumn(name = "fk_cpf_cliente", referencedColumnName = "cpf")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "fk_tipo_conta", referencedColumnName = "id_tipo_conta")
    private TipoContaEntity tipoConta;

    @OneToOne(mappedBy = "conta")
    private ContaCorrenteEntity contaCorrente;

    @OneToOne(mappedBy = "conta")
    private ContaPoupancaEntity contaPoupanca;

    @OneToMany(mappedBy = "contaOrigem")
    private List<TransferenciaEntity> transferenciaOrigem;

    @OneToMany(mappedBy = "contaDestino")
    private List<TransferenciaEntity> transferenciaDestino;


}
