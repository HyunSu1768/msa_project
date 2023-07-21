package com.example.filter;

import com.example.common.exception.BusinessException;
import com.example.common.exception.ErrorCode;
import com.example.env.JwtProperty;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;


@Slf4j
@Component
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<Object> {

    private JwtProperty jwtProperty;

    public AuthorizationHeaderFilter(JwtProperty jwtProperty) {
        this.jwtProperty = jwtProperty;
    }

    @Data
    public static class Config {
        private String header;

        private String secretKey;
    }

    @Override
    public GatewayFilter apply(Object config) {

        return (exchange, chain) -> {
            String authToken = exchange.getRequest().getHeaders().getFirst(jwtProperty.getHeader());

            if (StringUtils.isEmpty(authToken) || !authToken.startsWith(jwtProperty.getPrefix())) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            if(StringUtils.hasText(authToken) && authToken.startsWith(jwtProperty.getPrefix())
                    && authToken.length() > jwtProperty.getPrefix().length()+1){
                authToken = authToken.substring(7);
            }

            Claims body = getBody(authToken);

            if(body.getExpiration().before(new Date())) {
                throw new BusinessException(ErrorCode.EXPIRED_TOKEN_ERROR);
            } else {
                body.getSubject();
            }

            return chain.filter(exchange);
        };
    }

    private Claims getBody(String token) {
        try{
            return Jwts.parser().setSigningKey(jwtProperty.getSecretKey()).parseClaimsJws(token).getBody();
        } catch (JwtException e){
            throw new BusinessException(ErrorCode.EXPIRED_TOKEN_ERROR);
        }
    }

}
