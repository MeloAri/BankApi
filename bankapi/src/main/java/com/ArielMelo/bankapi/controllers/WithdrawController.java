package com.ArielMelo.bankapi.controllers;


import com.ArielMelo.bankapi.dtos.MessageRespondeDTO;
import com.ArielMelo.bankapi.dtos.WithDrawRequestDTO;
import com.ArielMelo.bankapi.services.WithdrawService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/withdraws")
@RequiredArgsConstructor
public class WithdrawController {

    private final WithdrawService withdrawService;

    @PostMapping
    public ResponseEntity<MessageRespondeDTO> withdraw(@RequestBody @Valid WithDrawRequestDTO dto){
        withdrawService.withdraw(dto.getAccountId(), dto.getAmount());

        return ResponseEntity.ok(
                new MessageRespondeDTO("Saque realizado com sucesso")
        );
    }

}
