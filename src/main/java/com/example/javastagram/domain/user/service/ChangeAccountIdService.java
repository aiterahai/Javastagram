package com.example.javastagram.domain.user.service;

import com.example.javastagram.domain.user.domain.User;
import com.example.javastagram.domain.user.exception.EarlyChangeAccountIdException;
import com.example.javastagram.domain.user.facade.UserFacade;
import com.example.javastagram.domain.user.presentation.dto.request.ChangeAccountIdRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ChangeAccountIdService {

    private final UserFacade userFacade;

    @Transactional
    public void execute(ChangeAccountIdRequest request) {

        User user = userFacade.getCurrentUser();

        if (!LocalDateTime.now().minusDays(14).isAfter(user.getModifiedAt())) {
            throw EarlyChangeAccountIdException.EXCEPTION;
        }

        user.changeAccountId(request.getAccountId());
    }
}
