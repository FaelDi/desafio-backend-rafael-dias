package com.wordpress.faeldi.desafio.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizeResponse {

    @JsonProperty("status")
    private String status;

    @JsonProperty("data")
    @NotNull
    private AuthorizeData data;
}
