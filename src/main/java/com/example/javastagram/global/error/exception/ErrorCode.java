package com.example.javastagram.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    ACCOUNT_ID_EXISTS(409, "USER-409-1", "Account Id Already Exists");

    private final int status;
    private final String code;
    private final String message;
}
