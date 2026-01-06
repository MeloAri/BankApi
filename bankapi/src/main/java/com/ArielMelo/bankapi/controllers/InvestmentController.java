package com.ArielMelo.bankapi.controllers;

import com.ArielMelo.bankapi.dtos.InvestmentRequestDTO;
import com.ArielMelo.bankapi.dtos.MessageRespondeDTO;
import com.ArielMelo.bankapi.services.InvestmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/investment")
@RequiredArgsConstructor
public class InvestmentController {

    private final InvestmentService investmentService;

    @PostMapping
    public ResponseEntity<MessageRespondeDTO> invest(@RequestBody @Valid InvestmentRequestDTO dto){
        investmentService.invest(
                dto.getAccountId(),
                dto.getAmount(),
                dto.getType()
        );

        return ResponseEntity.ok(
                new MessageRespondeDTO("Investimento realizado com sucesso")
        );
    }
}
