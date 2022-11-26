package com.example.javastagram.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class ChangeAccountIdRequest {

    @Size(min = 2, max = 30, message = "아이디는 2자 이상, 30자 이하여야 합니다.")
    private String accountId;
}
