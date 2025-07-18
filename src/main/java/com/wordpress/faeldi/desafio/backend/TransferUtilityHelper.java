package com.wordpress.faeldi.desafio.backend;

import com.wordpress.faeldi.desafio.backend.models.TransferPermissionChecker;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TransferUtilityHelper {
    public static boolean isTransferAllowed(TransferPermissionChecker obj) {
        if(obj.isTransferAllowed()) {
            return true;
        }
        return false;
    }
}
