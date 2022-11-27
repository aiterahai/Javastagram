package com.example.javastagram.domain.user.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(columnDefinition = "VARCHAR(30)", unique = true)
    private String accountId;

    @NotNull
    @Column(columnDefinition = "CHAR(60)")
    private String password;

    @NotNull
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime modifiedIdAt;

    public void changeAccountId(String accountId, LocalDateTime modifiedIdAt) {
        this.accountId = accountId;
        this.modifiedIdAt = modifiedIdAt;
    }
}
