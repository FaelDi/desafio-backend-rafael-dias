package com.wordpress.faeldi.desafio.backend.service.impl;

import com.wordpress.faeldi.desafio.backend.TransferUtilityHelper;
import com.wordpress.faeldi.desafio.backend.exception.TransferNotAllowedException;
import com.wordpress.faeldi.desafio.backend.exception.TransferNotAuthorized;
import com.wordpress.faeldi.desafio.backend.exception.UserNotFoundExepction;
import com.wordpress.faeldi.desafio.backend.models.TransferRequest;
import com.wordpress.faeldi.desafio.backend.repository.TransferRepository;
import com.wordpress.faeldi.desafio.backend.repository.UserRepository;
import com.wordpress.faeldi.desafio.backend.service.TransferBaseServce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class TransferServiceImpl implements TransferBaseServce<TransferRequest> {
    private final TransferRepository transferRepository;
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final AuthorizeServiceImpl authorizeService;

    public TransferServiceImpl(TransferRepository transferRepository,
                               UserRepository userRepository,
                               RestTemplate restTemplate,
                               AuthorizeServiceImpl authorizeService) {
        this.transferRepository = transferRepository;
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
        this.authorizeService = authorizeService;
    }

    @Override
    public ResponseEntity transfer(TransferRequest transferRequest) {
        var payer = userRepository.findById(transferRequest.getPayer())
                .orElseThrow(() -> new UserNotFoundExepction("Payer Not Found"));
        var payee = userRepository.findById(transferRequest.getPayee())
                .orElseThrow(() -> new UserNotFoundExepction("Payee Not Found"));

        if (!TransferUtilityHelper.isTransferAllowed(payer.getType())) {
            throw new TransferNotAllowedException("Transfer not Allowed to this user");
        }
        log.info("Payer has transfer allowed");

        if(TransferUtilityHelper.isTransferAllowed(payee.getType())) {
            throw new TransferNotAllowedException("Payee not able to receive money");
        }

        log.info("Payee able to receive money");
        var response = authorizeService.checkIfTransferIsAuthorized();

        if(!response.getStatusCode().equals(HttpStatus.OK)){
            throw new TransferNotAuthorized("Transfer is not Authorized");
        }

        payee.setAccountBalance(payee.getAccountBalance().add(transferRequest.getValue()));
        payer.setAccountBalance(payer.getAccountBalance().subtract(transferRequest.getValue()));



        return ResponseEntity.badRequest().build();
    }
}
