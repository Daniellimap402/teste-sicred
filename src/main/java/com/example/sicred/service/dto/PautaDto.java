package com.example.sicred.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PautaDto {

    private Long id;

    @NotBlank
    @Size(max = 100, min = 5)
    private String titulo;

    private Long tempo;

}
