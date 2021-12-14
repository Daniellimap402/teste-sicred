package com.example.sicred.web.rest;

import com.example.sicred.service.VotoService;
import com.example.sicred.service.dto.VotoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/votos")
@Slf4j
public class VotoResource {

    private final VotoService service;

    @PostMapping
    public ResponseEntity<VotoDto> salvar(@RequestBody VotoDto dto){
        log.info("Requisição REST para salvar um Voto: {}", dto);
        return new ResponseEntity<>(this.service.salvar(dto), HttpStatus.CREATED);
    }
}
