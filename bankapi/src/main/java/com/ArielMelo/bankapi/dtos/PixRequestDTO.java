package com.ArielMelo.bankapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;


@Getter
@Setter
public class PixRequestDTO {

    @NotNull
    private UUID fromAccountId;

    @NotBlank
    private String pixKey;

    @NotNull
    @Positive
    private BigDecimal amount;
}
