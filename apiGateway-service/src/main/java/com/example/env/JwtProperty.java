package com.example.env;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Base64;

@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
public class JwtProperty {

    private final String secretKey;

    private final Long accessExpiredExp;

    private final Long refreshExpiredExp;

    private final String header;

    private final String prefix;

    public JwtProperty(String secretKey, Long accessExpiredExp, Long refreshExpiredExp, String header, String prefix) {
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        this.accessExpiredExp = accessExpiredExp;
        this.refreshExpiredExp = refreshExpiredExp;
        this.header = header;
        this.prefix = prefix;
    }

}