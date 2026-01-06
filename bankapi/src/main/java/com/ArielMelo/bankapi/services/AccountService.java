package com.ArielMelo.bankapi.services;

import com.ArielMelo.bankapi.entities.Account;
import com.ArielMelo.bankapi.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account findById(UUID accountId){
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }

    public void save(Account account){
        accountRepository.save(account);
    }
}
