package com.ArielMelo.notification_service.events;
import com.ArielMelo.events.DepositCreatedEvent;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionNotificationEvent(UUID accountId,
                                           String userEmail,
                                           BigDecimal amount,
                                           String type) {
}
