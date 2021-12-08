package com.example.sicred.service;

import com.example.sicred.repository.VotoRepository;
import com.example.sicred.web.rest.exceptions.NegocioException;
import com.example.sicred.service.dto.AssociadoDto;
import com.example.sicred.service.dto.VotoDto;
import com.example.sicred.service.enumeration.VotoAptoEnum;
import com.example.sicred.service.feign.UserClient;
import com.example.sicred.service.mapper.VotoMapper;
import com.example.sicred.service.util.ConstantsUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class VotoService {

    private final VotoRepository repository;

    private final PautaService pautaService;

    private final AssociadoService associadoService;

    private final VotoMapper mapper;

    private final UserClient client;

    public VotoDto salvar(VotoDto dto){
        AssociadoDto associadoDto = this.associadoService.getAssociado(dto.getIdAssociado());
        verificarAssociadoCapazVoto(associadoDto);
        this.existePorAssociadoEPauta(dto.getIdAssociado(), dto.getIdPauta());
        this.verificarPautaAberta(dto);
        return this.mapper.toDto(this.repository.save(this.mapper.toEntity(dto)));
    }

    private void verificarAssociadoCapazVoto(AssociadoDto associadoDto) {
        if(!VotoAptoEnum.ABLE_TO_VOTE.equals(this.client.verificarCpfValido(associadoDto.getCpf()).getStatus())){
            throw new NegocioException(ConstantsUtil.ASSOCIADO_INCAPAZ_VOTAR);
        }
    }

    private void verificarPautaAberta(VotoDto dto) {
        if(!this.pautaService.getPautaAberta(dto.getIdPauta())){
            throw new NegocioException(ConstantsUtil.PAUTA_JA_FECHADA);
        }
    }

    private void existePorAssociadoEPauta(Long idAssociado, Long idPauta){
        if(this.repository.existsByAssociadoIdAndPautaId(idAssociado, idPauta)){
            throw new NegocioException(ConstantsUtil.CANDIDATO_JA_VOTOU);
        }
    }
}
