package com.wordpress.faeldi.desafio.backend.enums;

import com.wordpress.faeldi.desafio.backend.models.TransferPermissionChecker;
import lombok.Getter;

public enum UserType implements TransferPermissionChecker {
    USUARIO(true),
    LOGISTA(false);

    @Getter
    private final boolean transferAllowed;

    UserType(boolean transferAllowed) {
        this.transferAllowed = transferAllowed;
    }

}
