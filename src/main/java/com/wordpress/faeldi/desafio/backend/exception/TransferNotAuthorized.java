package com.wordpress.faeldi.desafio.backend.exception;

public class TransferNotAuthorized extends RuntimeException {
    public TransferNotAuthorized(String message) {
        super(message);
    }
}
