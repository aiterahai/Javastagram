package com.example.javastagram.domain.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginRequest {

    @NotBlank(message = "아이디를 입력해주세요.")
    private String accountId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;
}
