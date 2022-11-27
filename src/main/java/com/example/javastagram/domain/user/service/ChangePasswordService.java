package com.example.javastagram.domain.user.service;

import com.example.javastagram.domain.user.domain.User;
import com.example.javastagram.domain.user.facade.UserFacade;
import com.example.javastagram.domain.user.presentation.dto.request.ChangePasswordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChangePasswordService {

    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(ChangePasswordRequest request) {

        User user = userFacade.getCurrentUser();

        user.changePassword(passwordEncoder.encode(request.getPassword()));
    }
}
