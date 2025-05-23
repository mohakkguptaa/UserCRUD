package com.example.UserCRUD.Exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private String message;

    private int status_code;

    private LocalDateTime timestamp;

    ErrorResponse(String message, int status_code){
        this.message = message;
        this.status_code = status_code;
        timestamp = LocalDateTime.now();
    }
}
