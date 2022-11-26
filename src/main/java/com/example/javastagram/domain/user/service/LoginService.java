package com.example.javastagram.domain.user.service;

import com.example.javastagram.domain.user.domain.User;
import com.example.javastagram.domain.user.exception.PasswordNotMatchException;
import com.example.javastagram.domain.user.facade.UserFacade;
import com.example.javastagram.domain.user.presentation.dto.request.LoginRequest;
import com.example.javastagram.domain.user.presentation.dto.response.TokenResponse;
import com.example.javastagram.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse execute(LoginRequest request) {

        User user = userFacade.findUserByAccountId(request.getAccountId());

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordNotMatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(request.getAccountId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(request.getAccountId());

        return new TokenResponse(accessToken, refreshToken);
    }
}
