package com.ArielMelo.bankapi.dtos;

import jakarta.validation.constraints.NotBlank;

public record CreateAccountRequestDTO(@NotBlank String agency,
                                      @NotBlank String number) {
}
