package com.wordpress.faeldi.desafio.backend.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransferRequest {

    @NotNull
    private BigDecimal value;

    @NotNull
    private Integer payer;

    @NotNull
    private Integer payee;
}
