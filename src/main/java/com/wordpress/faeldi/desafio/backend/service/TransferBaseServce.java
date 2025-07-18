package com.wordpress.faeldi.desafio.backend.service;

import org.springframework.http.ResponseEntity;

@FunctionalInterface
public interface TransferBaseServce<T> {
    ResponseEntity<T> transfer(T obj);
}
