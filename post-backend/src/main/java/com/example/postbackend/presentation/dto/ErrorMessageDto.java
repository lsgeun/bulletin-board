package com.example.postbackend.presentation.dto;

public class ErrorMessageDto {
    public String message;

    public ErrorMessageDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
