package com.wordpress.faeldi.desafio.backend.service;

import java.util.List;

public interface BaseService<T, ValueType>{

    T create(ValueType obj);
    T findById(Long id);
    List<T> findAll();
    T edit(ValueType obj);
}
