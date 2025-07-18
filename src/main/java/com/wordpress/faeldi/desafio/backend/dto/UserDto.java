package com.wordpress.faeldi.desafio.backend.dto;

import com.wordpress.faeldi.desafio.backend.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class UserDto {

    private String fullName;

    private String email;

    private BigDecimal accountBalance;

    private UserType type;
}
