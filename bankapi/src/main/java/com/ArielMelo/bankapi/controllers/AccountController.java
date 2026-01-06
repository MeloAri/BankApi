package com.ArielMelo.bankapi.controllers;

import com.ArielMelo.bankapi.dtos.CreateAccountRequestDTO;
import com.ArielMelo.bankapi.entities.Account;
import com.ArielMelo.bankapi.services.CreateAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final CreateAccountService createAccountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(
            @RequestBody @Valid CreateAccountRequestDTO dto,
            Authentication authentication
    ) {

        String email = authentication.getName(); // vem do JWT

        Account account = createAccountService.create(
                email,
                dto.agency(),
                dto.number()
        );

        return ResponseEntity.ok(account);
    }
}
