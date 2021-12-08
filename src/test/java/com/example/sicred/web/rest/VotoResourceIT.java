package com.example.sicred.web.rest;

import com.example.sicred.SicredApplication;
import com.example.sicred.builder.VotoBuilder;
import com.example.sicred.service.dto.VotoDto;
import com.example.sicred.service.enumeration.VotoAptoEnum;
import com.example.sicred.service.feign.UserClient;
import com.example.sicred.service.feign.dto.StatusDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SicredApplication.class)
public class VotoResourceIT extends TestResourceIT{

    private final static String URL = "/api/votos";

    @Autowired
    private VotoBuilder builder;

    @MockBean
    private UserClient client;

    @Test
    @Transactional
    @DisplayName("Salvar Voto")
    public void salvarVoto() throws Exception {
        this.setUpClient(VotoAptoEnum.ABLE_TO_VOTE);
        VotoDto dto = builder.construirDto();
        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(dto)))
                .andExpect(status().isCreated());

    }

    @Test
    @Transactional
    @DisplayName("Salvar Voto Erro pauta fechada")
    public void salvarVotoErroPautaAberta() throws Exception {
        this.setUpClient(VotoAptoEnum.ABLE_TO_VOTE);
        VotoDto dto = builder.construirDtoPautaDataLimite();
        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(dto)))
                .andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    @DisplayName("Salvar Voto Erro candidato já votou")
    public void salvarVotoCandidatoVotou() throws Exception {
        this.setUpClient(VotoAptoEnum.ABLE_TO_VOTE);
        VotoDto dto = builder.construirDto();
        builder.persistir(dto);
        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(dto)))
                .andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    @DisplayName("Salvar Voto Candidato Incapaz Voto")
    public void salvarVotoCandidatoIncapaz() throws Exception {
        this.setUpClient(VotoAptoEnum.UNABLE_TO_VOTE);

        VotoDto dto = builder.construirDto();
        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(dto)))
                .andExpect(status().isBadRequest());

    }

    private void setUpClient(VotoAptoEnum votoAptoEnum){
        Mockito.when(client.verificarCpfValido(Mockito.any())).
                thenReturn(new StatusDto(votoAptoEnum));
    }

}
