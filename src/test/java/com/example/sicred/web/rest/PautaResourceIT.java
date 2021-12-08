package com.example.sicred.web.rest;

import com.example.sicred.SicredApplication;
import com.example.sicred.builder.PautaBuilder;
import com.example.sicred.builder.VotoBuilder;
import com.example.sicred.domain.Pauta;
import com.example.sicred.service.dto.PautaDto;
import com.example.sicred.test.TestConstantesUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SicredApplication.class)
public class PautaResourceIT extends TestResourceIT {

    private final static String URL = "/api/pautas";

    @Autowired
    private PautaBuilder builder;

    @Autowired
    private VotoBuilder votoBuilder;

    @Test
    @Transactional
    @DisplayName("Salvar pauta")
    public void salvarPauta() throws Exception {
        PautaDto dto = builder.construirDto();
        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(dto)))
                .andExpect(status().isCreated());

    }

    @Test
    @Transactional
    @DisplayName("Salvar pauta com tempo")
    public void salvarPautaComTempo() throws Exception {
        PautaDto dto = builder.construirDto();
        dto.setTempo(TestConstantesUtil.TEMPO);
        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(dto)))
                .andExpect(status().isCreated());

    }

    @Test
    @Transactional
    @DisplayName("verificar resultado pauta")
    public void getResultadoPauta() throws Exception {
        Pauta pauta = builder.construir();
        mockMvc.perform(get(URL+ "/{id}", pauta.getId()))
                .andExpect(status().isOk());

    }

}
