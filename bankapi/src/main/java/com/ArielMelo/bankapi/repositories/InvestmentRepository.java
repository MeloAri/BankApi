package com.ArielMelo.bankapi.repositories;

import com.ArielMelo.bankapi.entities.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InvestmentRepository extends JpaRepository<Investment, UUID> {

    List<Investment> findByAccountId(UUID accountId);
}
