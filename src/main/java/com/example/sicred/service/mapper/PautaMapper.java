package com.example.sicred.service.mapper;

import com.example.sicred.domain.Pauta;
import com.example.sicred.service.dto.PautaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PautaMapper extends EntityMapper<PautaDto, Pauta>{
}
