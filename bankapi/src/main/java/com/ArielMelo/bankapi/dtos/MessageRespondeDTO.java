package com.ArielMelo.bankapi.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageRespondeDTO {

    private String message;

    public MessageRespondeDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
