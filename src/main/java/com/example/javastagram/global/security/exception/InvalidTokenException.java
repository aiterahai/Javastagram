package com.example.javastagram.global.security.exception;

import com.example.javastagram.global.error.CustomException;
import com.example.javastagram.global.error.ErrorCode;

public class InvalidTokenException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}