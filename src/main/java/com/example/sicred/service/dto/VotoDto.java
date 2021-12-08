package com.example.sicred.service.dto;

import com.example.sicred.service.enumeration.VotoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VotoDto {

    private Long idAssociado;
    private Long idPauta;
    private VotoEnum voto;

}
