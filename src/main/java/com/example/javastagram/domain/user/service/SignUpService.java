package com.example.javastagram.domain.user.service;

import com.example.javastagram.domain.user.domain.User;
import com.example.javastagram.domain.user.domain.repository.UserRepository;
import com.example.javastagram.domain.user.exception.AccountIdExistsException;
import com.example.javastagram.domain.user.facade.UserFacade;
import com.example.javastagram.domain.user.presentation.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignUpRequest request) {

        if (userFacade.existsUserByAccountId(request.getAccountId())) {
            throw AccountIdExistsException.EXCEPTION;
        }

        User user = User.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);
    }
}
