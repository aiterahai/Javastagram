package com.example.javastagram.domain.user.exception;

import com.example.javastagram.global.error.CustomException;
import com.example.javastagram.global.error.ErrorCode;

public class PasswordNotMatchException extends CustomException {
    public static final CustomException EXCEPTION =
            new PasswordNotMatchException();

    public PasswordNotMatchException() {
        super(ErrorCode.PASSWORD_NOT_MATCH);
    }
}
