package com.example.javastagram.domain.user.exception;

import com.example.javastagram.global.error.CustomException;
import com.example.javastagram.global.error.ErrorCode;

public class EarlyChangeAccountIdException extends CustomException {
    public static final CustomException EXCEPTION =
            new EarlyChangeAccountIdException();

    public EarlyChangeAccountIdException() {
        super(ErrorCode.EARLY_CHANGE_ACCOUNT_ID);
    }
}
