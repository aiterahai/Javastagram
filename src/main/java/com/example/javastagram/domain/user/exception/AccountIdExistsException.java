package com.example.javastagram.domain.user.exception;

import com.example.javastagram.global.error.exception.CustomException;
import com.example.javastagram.global.error.exception.ErrorCode;

public class AccountIdExistsException extends CustomException {
    public static final CustomException EXCEPTION =
            new AccountIdExistsException();

    public AccountIdExistsException() {
        super(ErrorCode.ACCOUNT_ID_EXISTS);
    }
}
