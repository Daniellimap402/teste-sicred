package com.example.sicred.service.mapper;

import java.util.List;

public interface EntityMapper<D,E> {

    D toDto(E e);

    E toEntity(D d);

}
