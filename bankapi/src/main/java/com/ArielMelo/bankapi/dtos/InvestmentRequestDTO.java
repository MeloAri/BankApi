package com.ArielMelo.bankapi.dtos;

import com.ArielMelo.bankapi.enums.InvestmentType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;


@Getter
@Setter
public class InvestmentRequestDTO {

    @NotNull
    private UUID accountId;

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotNull
    private InvestmentType type;
}
