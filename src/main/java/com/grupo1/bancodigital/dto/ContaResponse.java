package com.grupo1.bancodigital.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ContaResponse {

    private Long idConta;
    private String numeroConta;
    private String numeroAgencia;
    private Integer digitoConta;
    private String senha;
    private Double saldo;
    private Double taxaManutencao;
    private Double taxaRendimento;
    private TipoContaEnum conta;

}
