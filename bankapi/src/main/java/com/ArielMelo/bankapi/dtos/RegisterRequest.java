package com.ArielMelo.bankapi.dtos;

public record RegisterRequest(String name,
                              String email,
                              String password,
                              String cpf) {
}
