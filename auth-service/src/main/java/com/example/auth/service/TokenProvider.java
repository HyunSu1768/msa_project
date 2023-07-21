package com.example.auth.service;

import com.example.auth.controller.dto.response.TokenResponse;
import com.example.auth.env.JwtProperty;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class TokenProvider {

    private final JwtProperty jwtProperty;

    public TokenResponse generate(String accountId) {

        Date now = new Date();

        return TokenResponse.builder()
                .accessToken(
                        Jwts.builder()
                                .setSubject(accountId)
                                .setIssuedAt(now)
                                .setExpiration(new Date(now.getTime() + jwtProperty.getAccessExpiredExp()))
                                .signWith(SignatureAlgorithm.HS256, jwtProperty.getSecretKey())
                                .compact()
                )
                .build();
    }


}
