package com.ArielMelo.bankapi.controllers;

import com.ArielMelo.bankapi.dtos.MessageRespondeDTO;
import com.ArielMelo.bankapi.dtos.PixRequestDTO;
import com.ArielMelo.bankapi.services.PixService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pix")
@RequiredArgsConstructor
public class PixController {

    private final PixService pixService;

    public ResponseEntity<MessageRespondeDTO> transfer(@RequestBody @Valid PixRequestDTO dto){
        pixService.transfer(
                dto.getFromAccountId(),
                dto.getPixKey(),
                dto.getAmount()
        );

        return ResponseEntity.ok(
                new MessageRespondeDTO("PIX realizado com sucesso")
        );
    }
}
