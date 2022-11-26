package com.example.javastagram.global.security.jwt;

import com.example.javastagram.domain.user.domain.RefreshToken;
import com.example.javastagram.domain.user.domain.repository.RefreshTokenRepository;
import com.example.javastagram.global.security.auth.AuthDetailsService;
import com.example.javastagram.global.security.exception.ExpiredTokenException;
import com.example.javastagram.global.security.exception.InvalidTokenException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final AuthDetailsService authDetailsService;
    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;

    private String generateToken(String accountId, String type, Long exp) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setSubject(accountId)
                .claim("type", type)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }

    public String generateAccessToken(String accountId) {
        return generateToken(accountId, "ACCESS", jwtProperties.getAccessExp());
    }

    public String generateRefreshToken(String accountId) {
        String refresh = generateToken(accountId, "REFRESH", jwtProperties.getRefreshExp());

        refreshTokenRepository.save(RefreshToken.builder()
                .accountId(accountId)
                .token(refresh)
                .ttl(jwtProperties.getRefreshExp())
                .build());

        return refresh;
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService.loadUserByUsername(parseTokenBody(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String parseTokenBody(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtProperties.getSecretKey()).
                    parseClaimsJws(token).getBody().getSubject();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }
}
