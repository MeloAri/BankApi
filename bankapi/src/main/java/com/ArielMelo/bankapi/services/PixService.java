package com.ArielMelo.bankapi.services;

import com.ArielMelo.bankapi.entities.Account;
import com.ArielMelo.bankapi.entities.PixKey;
import com.ArielMelo.bankapi.entities.Transaction;
import com.ArielMelo.bankapi.enums.TransactionType;
import com.ArielMelo.bankapi.repositories.PixKeyRepository;
import com.ArielMelo.bankapi.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PixService {
    private final AccountService accountService;
    private final PixKeyRepository pixKeyRepository;
    private final TransactionRepository transactionRepository;

    @Transactional
    public void transfer(UUID fromAccountId, String pixKeyValue, BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Valor inválido");
        }

        Account from = accountService.findById(fromAccountId);

        PixKey pixKey = pixKeyRepository.findByKey(pixKeyValue)
                .orElseThrow(() -> new RuntimeException("Chave PIX não encontrada"));

        Account to = pixKey.getAccount();

        if (from.getId().equals(to.getId())) {
            throw new RuntimeException("Transferência para mesma conta não permitida");
        }

        if (from.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));

        accountService.save(from);
        accountService.save(to);

        Transaction out = new Transaction();
        out.setType(TransactionType.PIX_OUT);
        out.setAmount(amount);
        out.setCreatedAt(LocalDateTime.now());
        out.setAccount(from);

        Transaction in = new Transaction();
        in.setType(TransactionType.PIX_IN);
        in.setAmount(amount);
        in.setCreatedAt(LocalDateTime.now());
        in.setAccount(to);

        transactionRepository.save(out);
        transactionRepository.save(in);
    }
}
