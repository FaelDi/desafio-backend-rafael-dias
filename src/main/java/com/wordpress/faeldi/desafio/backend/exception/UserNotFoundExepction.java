package com.wordpress.faeldi.desafio.backend.exception;

public class UserNotFoundExepction extends RuntimeException{
    public UserNotFoundExepction(String message) {
        super(message);
    }
}
