package com.grupo1.bancodigital.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class EnderecoResponse {

    private Long id_endereco;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

}
