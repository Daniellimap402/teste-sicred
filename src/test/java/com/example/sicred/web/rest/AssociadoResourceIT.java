package com.example.sicred.web.rest;

import com.example.sicred.SicredApplication;
import com.example.sicred.builder.AssociadoBuilder;
import com.example.sicred.service.dto.AssociadoDto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SicredApplication.class)
public class AssociadoResourceIT extends TestResourceIT {

    private final static String URL = "/api/associados";

    @Autowired
    private AssociadoBuilder builder;

    @Test
    @Transactional
    @DisplayName("Salvar associado")
    public void salvarAssociado() throws Exception {
        AssociadoDto dto = builder.construirDto();
        mockMvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(dto)))
                .andExpect(status().isCreated());

    }

    @Test
    @Transactional
    @DisplayName("Salvar associado erro")
    public void salvarAssociadoErro() throws Exception {
        builder.construir();
        AssociadoDto associadoDto = builder.construirDto();
        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(associadoDto)))
                .andExpect(status().isBadRequest());

    }
}
