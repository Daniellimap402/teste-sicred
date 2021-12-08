package com.example.sicred.service.dto;

import lombok.Getter;
import lombok.Setter;

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
    @Size(max = 11, min = 11)
    private String cpf;

}
