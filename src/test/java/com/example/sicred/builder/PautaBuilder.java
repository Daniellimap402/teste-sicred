package com.example.sicred.builder;

import com.example.sicred.domain.Pauta;
import com.example.sicred.repository.PautaRepository;
import com.example.sicred.service.dto.PautaDto;
import com.example.sicred.service.mapper.PautaMapper;
import com.example.sicred.test.TestConstantesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class PautaBuilder {

    private final PautaMapper mapper;

    private final PautaRepository repository;

    public PautaDto construirDto(){
        PautaDto dto = new PautaDto();
        dto.setTitulo(TestConstantesUtil.TITULO);
        return dto;
    }

    public Pauta construir(){
        Pauta pauta = new Pauta();
        pauta.setTitulo(TestConstantesUtil.TITULO);
        pauta.setTempo(TestConstantesUtil.TEMPO);
        pauta.setDataLimite(LocalDateTime.now().plusMinutes(TestConstantesUtil.TEMPO));
        return this.repository.save(pauta);
    }

    public Pauta persistir(Pauta pauta){
        return this.repository.save(pauta);
    }
}
