package com.example.sicred.domain;

import com.example.sicred.service.enumeration.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Pauta implements Serializable {

    private static final long serialVersionUID = 6905980689460512174L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(name = "data_limite", nullable = false)
    private LocalDateTime dataLimite;

    @OneToMany(mappedBy = "pauta", orphanRemoval = true)
    private List<Voto> votos = new ArrayList<>();

    private StatusEnum status;

}
