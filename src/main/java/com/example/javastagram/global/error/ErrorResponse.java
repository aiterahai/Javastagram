package com.example.javastagram.global.error;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private final int statusCode;
    private final String message;

    public ErrorResponse(ErrorCode errorCode) {
        this.statusCode = errorCode.getStatus();
        this.message = errorCode.getMessage();
    }
}