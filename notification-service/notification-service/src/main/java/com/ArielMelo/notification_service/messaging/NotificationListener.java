package com.ArielMelo.notification_service.messaging;

import com.ArielMelo.events.DepositCreatedEvent;
import com.ArielMelo.notification_service.config.RabbitMQConfig;
import com.ArielMelo.notification_service.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.ArielMelo.events.DepositCreatedEvent;

@Component
@RequiredArgsConstructor
public class NotificationListener {

    private final EmailService emailService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void onDeposit(DepositCreatedEvent event) {
        emailService.sendDepositNotification(event);
    }
}
