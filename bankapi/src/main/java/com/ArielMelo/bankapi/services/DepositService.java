package com.ArielMelo.bankapi.services;


import com.ArielMelo.bankapi.entities.Account;
import com.ArielMelo.bankapi.entities.Transaction;
import com.ArielMelo.bankapi.enums.TransactionType;
import com.ArielMelo.bankapi.repositories.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DepositService {

    private final AccountService accountService;
    private final TransactionRepository transactionRepository;

    @Transactional
    public void deposit(UUID accountId, BigDecimal amount){

        if(amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new RuntimeException("Valor de depósito deve ser maior que zero");
        }


        Account account = accountService.findById(accountId);

        account.setBalance(account.getBalance().add(amount));
        accountService.save(account);


        Transaction tx = new Transaction();
        tx.setType(TransactionType.DEPOSIT);
        tx.setAmount(amount);
        tx.setCreatedAt(LocalDateTime.now());
        tx.setAccount(account);

        transactionRepository.save(tx);

    }
}
