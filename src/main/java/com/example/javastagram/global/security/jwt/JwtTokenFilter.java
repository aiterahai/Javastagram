package com.example.javastagram.global.security.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenResolver jwtTokenResolver;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = jwtTokenResolver.resolveToken(request);
        if (token != null) {
            Authentication authentication = jwtTokenProvider.authentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            SecurityContextHolder.clearContext();
        }
        filterChain.doFilter(request, response);
    }

}