package com.example.javastagram.domain.user.facade;

import com.example.javastagram.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public Boolean existsUserByAccountId(String accountId) {
        return userRepository.existsUserByAccountId(accountId);
    }
}
