package com.grupo1.bancodigital.dto;

import com.grupo1.bancodigital.model.cartao.TipoCartaoEntity;
import com.grupo1.bancodigital.model.conta.ContaEntity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CartaoResponse {

    private Long numeroCartao;
    private Long cvv;
    private Double limite;
    private LocalDate dataVencimento;
}
