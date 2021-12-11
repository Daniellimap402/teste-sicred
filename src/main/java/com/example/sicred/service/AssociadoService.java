package com.example.sicred.service;

import com.example.sicred.repository.AssociadoRepository;
import com.example.sicred.web.rest.exceptions.NegocioException;
import com.example.sicred.service.dto.AssociadoDto;
import com.example.sicred.service.mapper.AssociadoMapper;
import com.example.sicred.service.util.ConstantsUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AssociadoService {

    private final AssociadoRepository repository;

    private final AssociadoMapper mapper;

    public AssociadoDto salvar(AssociadoDto dto) {
        if(this.repository.existsByCpf(dto.getCpf())){
            throw new NegocioException(ConstantsUtil.CPF_JA_EXISTENTE);
        }
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public AssociadoDto getAssociado(Long id){
        return this.mapper.toDto(this.repository.findById(id).orElseThrow(() -> {
            throw new NegocioException(ConstantsUtil.ASSOCIADO_NAO_ENCONTRADO);
        }));
    }

}
