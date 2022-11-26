package com.example.javastagram.domain.user.domain.repository;

import com.example.javastagram.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsUserByAccountId(String accountId);
}
