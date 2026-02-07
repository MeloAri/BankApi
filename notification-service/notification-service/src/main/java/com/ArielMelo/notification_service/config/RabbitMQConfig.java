package com.ArielMelo.notification_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ArielMelo.events.DepositCreatedEvent;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "notification.deposit.queue";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }
}
