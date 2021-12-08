package com.example.sicred.repository;

import com.example.sicred.domain.Associado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {

    boolean existsByCpf(String cpf);
}
