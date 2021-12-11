package com.example.sicred.service;

import com.example.sicred.domain.Pauta;
import com.example.sicred.domain.Voto;
import com.example.sicred.repository.PautaRepository;
import com.example.sicred.service.dto.PautaDto;
import com.example.sicred.service.enumeration.StatusEnum;
import com.example.sicred.service.enumeration.VotoEnum;
import com.example.sicred.service.mapper.PautaMapper;
import com.example.sicred.service.util.ConstantsUtil;
import com.example.sicred.web.rest.exceptions.NegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class PautaService {

    private final PautaRepository repository;

    private final PautaMapper mapper;

    private static final Long TEMPO_PADRAO = 1L;

    public PautaDto salvar(PautaDto dto){
        Pauta pauta = this.mapper.toEntity(dto);
        setTempoPauta(dto, pauta);
        return this.mapper.toDto(this.repository.save(pauta));
    }

    private void setTempoPauta(PautaDto dto, Pauta pauta) {
        if(Objects.isNull(dto.getTempo())){
            pauta.setDataLimite(LocalDateTime.now().plusMinutes(TEMPO_PADRAO));
            return;
        }
        pauta.setDataLimite(LocalDateTime.now().plusMinutes(dto.getTempo()));
        pauta.setStatus(StatusEnum.A);
    }

    public Boolean getPautaAberta(Long id){
        Pauta pauta = this.repository.findById(id).orElseThrow(() -> {
            throw new NegocioException(ConstantsUtil.PAUTA_NAO_ENCONTRADA);
        });
        return pauta.getDataLimite().isAfter(LocalDateTime.now());
    }

    public String getResultadoVotacao(Long id){
        List<Voto> votos = this.repository.findById(id).orElseThrow(() -> {
            throw new NegocioException(ConstantsUtil.PAUTA_NAO_ENCONTRADA);
        }).getVotos();
        List votosSim = verificarVotos(votos);
        return verificarQuantidadeVotos(votosSim, votos);
    }

    private String verificarQuantidadeVotos(List votosSim, List votos) {
        final Integer METADE_LISTA = 2;
        if(votosSim.size()>(votos.size()/METADE_LISTA)){
            return VotoEnum.S.getValue();
        } if(votosSim.size()<((double) votos.size()/METADE_LISTA)){
            return VotoEnum.N.getValue();
        } else {
            return ConstantsUtil.PAUTA_EMPATADA;
        }
    }

    private List<Voto> verificarVotos(List<Voto> votos) {
        return votos.stream()
                .filter(voto -> VotoEnum.S.equals(voto.getVoto())).collect(Collectors.toList());
    }

    public List<Pauta> buscarPautasAbertas(){
        return this.repository.getByStatus(StatusEnum.A);
    }

    public void saveAll(List<Pauta> pautas) {
        this.repository.saveAll(pautas);
    }

}
