package com.example.sicred.web.rest;

import com.example.sicred.service.AssociadoService;
import com.example.sicred.service.dto.AssociadoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/associados")
public class AssociadoResource {

    private final AssociadoService service;

    @PostMapping()
    public ResponseEntity<AssociadoDto> salvar(@RequestBody AssociadoDto dto){
        return new ResponseEntity<>(this.service.salvar(dto), HttpStatus.CREATED);
    }

}
