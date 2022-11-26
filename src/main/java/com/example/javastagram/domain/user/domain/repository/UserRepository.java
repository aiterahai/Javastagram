package com.example.javastagram.domain.user.domain.repository;

import com.example.javastagram.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsUserByAccountId(String accountId);

    Optional<User> findUserByAccountId(String accountId);
}
