package com.ArielMelo.bankapi.repositories;

import com.ArielMelo.bankapi.entities.PixKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PixKeyRepository extends JpaRepository<PixKey, UUID> {

    Optional<PixKey> findByKey(String key);

    boolean existsByKey(String key);
}
