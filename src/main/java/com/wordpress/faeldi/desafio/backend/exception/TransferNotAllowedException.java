package com.wordpress.faeldi.desafio.backend.exception;

public class TransferNotAllowedException extends RuntimeException {
    public TransferNotAllowedException(String message) {
        super(message);
    }
}
