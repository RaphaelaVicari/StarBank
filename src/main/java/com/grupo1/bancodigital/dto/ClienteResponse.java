package com.grupo1.bancodigital.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ClienteResponse {

    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private CategoriaEnum categoria;

}
