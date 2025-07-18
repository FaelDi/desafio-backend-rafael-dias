package com.wordpress.faeldi.desafio.backend.enums;

import lombok.Getter;

public enum UserType {
    USUARIO(true),
    LOGISTA(false);

    @Getter
    private final boolean transferAllowed;

    UserType(boolean transferAllowed) {
        this.transferAllowed = transferAllowed;
    }

}
