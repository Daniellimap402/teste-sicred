package com.example.sicred.service.mapper;

import com.example.sicred.domain.Voto;
import com.example.sicred.service.dto.VotoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VotoMapper extends EntityMapper<VotoDto, Voto>{

    @Mapping(source = "associado.id", target = "idAssociado")
    @Mapping(source = "pauta.id", target = "idPauta")
    @Override
    VotoDto toDto(Voto voto);

    @Mapping(source = "idAssociado", target = "associado.id")
    @Mapping(source = "idPauta", target = "pauta.id")
    @Override
    Voto toEntity(VotoDto dto);
}
