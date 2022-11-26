package com.example.javastagram.domain.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequest {

    @Size(min = 2, max = 30, message = "아이디는 2자 이상, 30자 이하여야 합니다.")
    private String accountId;

    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상, 20자 이하여야 합니다.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]$",
            message = "비밀번호는 하나 이상의 문자, 하나 이상의 숫자, 하나 이상의 특수 문자를 포함해야 합니다.")
    private String password;
}
