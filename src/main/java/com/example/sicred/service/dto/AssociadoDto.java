package com.example.sicred.service.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AssociadoDto {

    private Long id;

    @NotBlank
    @Size(max = 100, min = 1)
    private String nome;

    @NotBlank
    @CPF
    private String cpf;

}
