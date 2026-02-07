package com.ArielMelo.notification_service.services;

import com.ArielMelo.events.DepositCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.ArielMelo.events.DepositCreatedEvent;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendDepositNotification(DepositCreatedEvent event) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(event.email());
        message.setSubject("Depósito realizado");
        message.setText("""
                Olá!

                Seu depósito no valor de R$ %s foi realizado com sucesso.

                Obrigado por usar nosso banco.
                """.formatted(event.amount()));

        mailSender.send(message);
    }
}
