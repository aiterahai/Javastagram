package com.example.javastagram.domain.user.presentation;

import com.example.javastagram.domain.user.presentation.dto.request.SignUpRequest;
import com.example.javastagram.domain.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final SignUpService signUpService;

    @GetMapping("/signup")
    public void signup(@RequestBody @Valid SignUpRequest request) {
        signUpService.execute(request);
    }
}
