package com.wordpress.faeldi.desafio.backend.service.impl;

import com.wordpress.faeldi.desafio.backend.models.TransferRequest;
import com.wordpress.faeldi.desafio.backend.repository.TransferRepository;
import com.wordpress.faeldi.desafio.backend.service.TransferBaseServce;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferBaseServce<TransferRequest> {
    private final TransferRepository transferRepository;

    public TransferServiceImpl(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Override
    public ResponseEntity<TransferRequest> transfer(TransferRequest transferRequest) {
        return ResponseEntity.ok(transferRequest);
    }
}
