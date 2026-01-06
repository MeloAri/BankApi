package com.ArielMelo.bankapi.services;


import com.ArielMelo.bankapi.entities.Account;
import com.ArielMelo.bankapi.entities.Investment;
import com.ArielMelo.bankapi.entities.Transaction;
import com.ArielMelo.bankapi.enums.InvestmentType;
import com.ArielMelo.bankapi.enums.TransactionType;
import com.ArielMelo.bankapi.repositories.InvestmentRepository;
import com.ArielMelo.bankapi.repositories.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InvestmentService {

    private final AccountService accountService;
    private final InvestmentRepository investmentRepository;
    private final TransactionRepository transactionRepository;

    @Transactional
    public void invest(UUID accountId, BigDecimal amount, InvestmentType type) {

        Account account = accountService.findById(accountId);

        if (account.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        BigDecimal rate = type == InvestmentType.SAVINGS
                ? new BigDecimal("0.005")
                : new BigDecimal("0.01");

        account.setBalance(account.getBalance().subtract(amount));
        accountService.save(account);

        Investment investment = new Investment();
        investment.setType(type);
        investment.setAmount(amount);
        investment.setInterestRate(rate);
        investment.setCreatedAt(LocalDateTime.now());
        investment.setAccount(account);

        investmentRepository.save(investment);

        Transaction tx = new Transaction();
        tx.setType(TransactionType.INVEST);
        tx.setAmount(amount);
        tx.setCreatedAt(LocalDateTime.now());
        tx.setAccount(account);

        transactionRepository.save(tx);
    }
}


