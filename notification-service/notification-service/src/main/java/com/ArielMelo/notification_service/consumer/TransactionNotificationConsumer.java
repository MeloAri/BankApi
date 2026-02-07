package com.ArielMelo.notification_service.consumer;

import com.ArielMelo.events.DepositCreatedEvent;
import com.ArielMelo.notification_service.config.RabbitMQConfig;
import com.ArielMelo.notification_service.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.ArielMelo.events.DepositCreatedEvent;

@RequiredArgsConstructor
@Component
public class TransactionNotificationConsumer {

    private final EmailService emailService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receive(DepositCreatedEvent event) {
        emailService.sendDepositNotification(event);
    }
}
