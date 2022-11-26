package com.example.javastagram.global.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    EXPIRED_TOKEN(401, "AUTH-401-1", "Token Expired"),
    INVALID_TOKEN(401, "AUTH-401-2", "Token Invalid"),
    PASSWORD_NOT_MATCH(401, "USER-401-1", "Password Not Match"),

    EARLY_CHANGE_ACCOUNT_ID(403, "USER-403-1", "Waiting Time Does Not Pass"),

    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),

    ACCOUNT_ID_EXISTS(409, "USER-409-1", "Account Id Already Exists"),

    INTERNAL_SERVER_ERROR(500, "SERVER-500-1", "Server Error");

    private final int status;
    private final String code;
    private final String message;
}
