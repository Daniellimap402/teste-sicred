package com.example.sicred.domain;

import com.example.sicred.service.enumeration.VotoEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Voto implements Serializable {

    private static final long serialVersionUID = 680752857035161774L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Associado associado;

    @ManyToOne(optional = false)
    private Pauta pauta;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VotoEnum voto;

}
