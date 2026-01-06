package com.ArielMelo.bankapi.services;

import com.ArielMelo.bankapi.entities.Account;
import com.ArielMelo.bankapi.entities.User;
import com.ArielMelo.bankapi.repositories.AccountRepository;
import com.ArielMelo.bankapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CreateAccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public Account create(String userEmail, String agency, String number){

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Account account = new Account();
        account.setAgency(agency);
        account.setAccountNumber(number);
        account.setBalance(BigDecimal.ZERO);
        account.setUser(user);

        return accountRepository.save(account);
    }
}
