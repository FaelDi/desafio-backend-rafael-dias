package com.wordpress.faeldi.desafio.backend.controller;

import com.wordpress.faeldi.desafio.backend.models.TransferRequest;
import com.wordpress.faeldi.desafio.backend.service.TransferBaseServce;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    private final TransferBaseServce<TransferRequest> transferBaseServce;

    public TransferController(TransferBaseServce transferBaseServce) {
        this.transferBaseServce = transferBaseServce;
    }

    @PostMapping
    private ResponseEntity sendTransfer(@RequestBody @Valid TransferRequest transferRequest){
        return transferBaseServce.transfer(transferRequest);
    }
}
