package com.example.sicred.repository;

import com.example.sicred.domain.Pauta;
import com.example.sicred.service.enumeration.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PautaRepository extends JpaRepository<Pauta, Long> {

    List<Pauta> getByStatus(StatusEnum statusEnum);
}
