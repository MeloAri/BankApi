package com.ArielMelo.events;

import java.math.BigDecimal;
import java.util.UUID;

public class DepositCreatedEvent {

    private UUID accountId;
    private BigDecimal amount;
    private String email;

    public DepositCreatedEvent() {
    }

    public DepositCreatedEvent(UUID accountId, BigDecimal amount, String email) {
        this.accountId = accountId;
        this.amount = amount;
        this.email = email;
    }

    public UUID getAccountId() { return accountId; }
    public BigDecimal getAmount() { return amount; }
    public String getEmail() { return email; }

    public void setAccountId(UUID accountId) { this.accountId = accountId; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setEmail(String email) { this.email = email; }
}
