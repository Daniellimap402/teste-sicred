package com.example.sicred.web.rest;

import com.example.sicred.service.PautaService;
import com.example.sicred.service.dto.PautaDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pautas")
@Slf4j
public class PautaResource {

    private final PautaService service;

    @PostMapping
    public ResponseEntity<PautaDto> salvar(@RequestBody PautaDto dto){
        log.debug("Requisição REST para salvar uma pauta: {}", dto);
        return new ResponseEntity<>(this.service.salvar(dto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<String> buscarResultadoPauta(@PathVariable Long id){
        log.debug("Requisição REST para obter o resultado de uma pauta: {}", id);
        return new ResponseEntity<>(this.service.buscarResultadoVotacao(id), HttpStatus.OK);
    }

}
