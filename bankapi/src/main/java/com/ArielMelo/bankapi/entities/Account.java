package com.ArielMelo.bankapi.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.UUID;


@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Account {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @Column(nullable = false, unique = true)
        private String accountNumber;

        @Column(nullable = false)
        private String agency;

        @Column(nullable = false)
        private BigDecimal balance;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;
    }

