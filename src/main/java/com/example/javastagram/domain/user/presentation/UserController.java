package com.example.javastagram.domain.user.presentation;

import com.example.javastagram.domain.user.presentation.dto.request.ChangeAccountIdRequest;
import com.example.javastagram.domain.user.presentation.dto.request.ChangePasswordRequest;
import com.example.javastagram.domain.user.presentation.dto.request.LoginRequest;
import com.example.javastagram.domain.user.presentation.dto.request.SignUpRequest;
import com.example.javastagram.domain.user.presentation.dto.response.TokenResponse;
import com.example.javastagram.domain.user.service.ChangeAccountIdService;
import com.example.javastagram.domain.user.service.ChangePasswordService;
import com.example.javastagram.domain.user.service.LoginService;
import com.example.javastagram.domain.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final SignUpService signUpService;
    private final LoginService loginService;
    private final ChangeAccountIdService changeAccountIdService;
    private final ChangePasswordService changePasswordService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignUpRequest request) {
        signUpService.execute(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/modify/id")
    public void changeAccountId(@RequestBody @Valid ChangeAccountIdRequest request) {
        changeAccountIdService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/modify/password")
    public void changePassword(@RequestBody @Valid ChangePasswordRequest request) {
        changePasswordService.execute(request);
    }
}
