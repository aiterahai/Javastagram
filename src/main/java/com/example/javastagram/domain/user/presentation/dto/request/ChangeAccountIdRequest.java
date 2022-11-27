package com.example.javastagram.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class ChangeAccountIdRequest {

    @Size(min = 2, max = 30, message = "아이디는 2자 이상, 30자 이하여야 합니다.")
    @Pattern(regexp = "^[a-zA-Z][0-9a-zA-Z._]{1,29}$",
            message = "아이디는 영문자로 시작해야 하며 숫자와 영문자, 특수문자 . _ 을 포함할 수 있습니다.")
    private String accountId;
}
