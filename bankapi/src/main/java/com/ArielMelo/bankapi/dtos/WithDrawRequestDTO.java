package com.ArielMelo.bankapi.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;


@Getter
@Setter
public class WithDrawRequestDTO {

    @NotNull
    private UUID accountId;

    @NotNull
    @Positive
    private BigDecimal amount;
}
