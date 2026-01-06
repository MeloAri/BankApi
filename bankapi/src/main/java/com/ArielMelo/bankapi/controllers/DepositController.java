package com.ArielMelo.bankapi.controllers;

import com.ArielMelo.bankapi.dtos.DepositRequestDTO;
import com.ArielMelo.bankapi.dtos.MessageRespondeDTO;
import com.ArielMelo.bankapi.services.DepositService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deposits")
@RequiredArgsConstructor
public class DepositController {

      private final DepositService depositService;

      @PostMapping
    public ResponseEntity<MessageRespondeDTO> deposito(@RequestBody @Valid DepositRequestDTO dto){
          depositService.deposit(dto.getAccountId(), dto.getAmount());

          return ResponseEntity.ok(
                  new MessageRespondeDTO("Depósito realizado com sucesso")
          );
      }
}
