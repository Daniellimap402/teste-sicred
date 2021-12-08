package com.example.sicred.repository;

import com.example.sicred.domain.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {

    boolean existsByAssociadoIdAndPautaId(Long idAssociado, Long idPauta);
}
