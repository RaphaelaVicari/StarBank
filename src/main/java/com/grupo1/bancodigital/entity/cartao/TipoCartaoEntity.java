package com.grupo1.bancodigital.entity.cartao;

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
@Table(name = "tipo-cartao")
@Builder(toBuilder = true)
public class TipoCartaoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_cartao", nullable = false)
    private Long idTipoCartao;

    @Column(name = "nome_tipo")
    private String nomeTipo;

    @OneToMany(mappedBy = "tipoCartao")
    private List<CartaoEntity> cartao;
}
