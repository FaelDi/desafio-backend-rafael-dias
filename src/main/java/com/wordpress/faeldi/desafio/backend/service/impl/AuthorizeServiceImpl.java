package com.wordpress.faeldi.desafio.backend.service.impl;

import com.wordpress.faeldi.desafio.backend.config.AppProperties;
import com.wordpress.faeldi.desafio.backend.exception.TransferNotAuthorized;
import com.wordpress.faeldi.desafio.backend.models.AuthorizeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class AuthorizeServiceImpl{

    private final RestTemplate restTemplate;
    private final AppProperties appProperties;

    public AuthorizeServiceImpl(RestTemplate restTemplate, AppProperties appProperties) {
        this.restTemplate = restTemplate;
        this.appProperties = appProperties;
    }

    public ResponseEntity<AuthorizeResponse> checkIfTransferIsAuthorized() {
        var response = restTemplate.getForEntity(appProperties.getAuthorizeServiceUrl(),AuthorizeResponse.class);

        if(response.getStatusCode().equals(HttpStatus.OK)){
            var authorizeResponse = response.getBody();
            if(authorizeResponse.getData().isAuthorization()){
                return ResponseEntity.ok(response.getBody());
            }
        }

        throw new TransferNotAuthorized("Transfer is not Authorized");
    }
}
