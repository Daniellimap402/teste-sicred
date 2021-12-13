package com.example.sicred.web.rest.builder;


import com.example.sicred.domain.Associado;
import com.example.sicred.domain.Pauta;
import com.example.sicred.domain.Voto;
import com.example.sicred.repository.VotoRepository;
import com.example.sicred.service.dto.VotoDto;
import com.example.sicred.service.enumeration.VotoEnum;
import com.example.sicred.service.mapper.VotoMapper;
import com.example.sicred.test.TestConstantesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class VotoBuilder {

    private final VotoMapper mapper;

    private final PautaBuilder pautaBuilder;

    private final AssociadoBuilder associadoBuilder;

    private final VotoRepository repository;

    public VotoDto construirDto(){
        Pauta pauta = pautaBuilder.construir();
        Associado associado = associadoBuilder.construir();
        VotoDto dto = new VotoDto();
        dto.setVoto(VotoEnum.S);
        dto.setIdAssociado(associado.getId());
        dto.setIdPauta(pauta.getId());
        return dto;
    }

    public Voto construir(){
        Voto voto = this.mapper.toEntity(this.construirDto());
        return this.repository.save(voto);
    }

    public VotoDto construirDtoPautaDataLimite(){
        Pauta pauta = criarPautaFechada();
        Associado associado = associadoBuilder.construir();
        VotoDto dto = new VotoDto();
        dto.setVoto(VotoEnum.S);
        dto.setIdAssociado(associado.getId());
        dto.setIdPauta(pauta.getId());
        return dto;
    }

    private Pauta criarPautaFechada() {
        Pauta pauta = new Pauta();
        pauta.setDataLimite(LocalDateTime.now());
        pauta.setTitulo(TestConstantesUtil.TITULO);
        pauta = pautaBuilder.persistir(pauta);
        return pauta;
    }

    public VotoDto persistir(VotoDto dto){
        return this.mapper.toDto(this.repository.save(this.mapper.toEntity(dto)));
    }
}
