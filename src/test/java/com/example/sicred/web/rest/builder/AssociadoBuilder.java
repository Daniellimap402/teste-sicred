package com.example.sicred.web.rest.builder;

import com.example.sicred.domain.Associado;
import com.example.sicred.repository.AssociadoRepository;
import com.example.sicred.service.dto.AssociadoDto;
import com.example.sicred.service.mapper.AssociadoMapper;
import com.example.sicred.test.TestConstantesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssociadoBuilder {

    private final AssociadoMapper mapper;

    private final AssociadoRepository repository;

    public AssociadoDto construirDto() {
        AssociadoDto dto = new AssociadoDto();
        dto.setCpf(TestConstantesUtil.CPF);
        dto.setNome(TestConstantesUtil.NOME);
        return dto;
    }

    public Associado construir(){
        Associado associado = new Associado();
        associado.setCpf(TestConstantesUtil.CPF);
        associado.setNome(TestConstantesUtil.NOME);
        return repository.save(associado);
    }

}
