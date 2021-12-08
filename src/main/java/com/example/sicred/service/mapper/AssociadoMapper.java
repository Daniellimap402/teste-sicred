package com.example.sicred.service.mapper;

import com.example.sicred.domain.Associado;
import com.example.sicred.service.dto.AssociadoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssociadoMapper extends EntityMapper<AssociadoDto, Associado>{
}
