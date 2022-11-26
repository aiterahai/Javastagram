package com.example.javastagram.domain.user.exception;

import com.example.javastagram.global.error.CustomException;
import com.example.javastagram.global.error.ErrorCode;

public class UserNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
