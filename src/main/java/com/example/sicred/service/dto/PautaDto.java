package com.example.sicred.service.dto;

import com.example.sicred.domain.Voto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class PautaDto {

    private Long id;

    @NotBlank
    @Size(max = 100, min = 5)
    private String titulo;

    private Long tempo;

    private List<Voto> votos;

}
