package com.ArielMelo.bankapi.entities;

import com.ArielMelo.bankapi.enums.PixKeyType;
import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Entity
@Table(name = "pix_keys")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PixKey {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private PixKeyType type;

    @Column(nullable = false, unique = true)
    private String key;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}

