package com.example.auth.application.service;

import com.example.auth.adapter.in.web.rest.dto.request.LoginRequest;
import com.example.auth.adapter.in.web.rest.dto.response.TokenResponse;
import com.example.auth.application.port.in.LoginUseCase;
import com.example.auth.application.port.out.feignClient.LoadUserPort;
import com.example.common.annotation.UseCase;
import com.example.common.exception.BusinessException;
import com.example.common.exception.ErrorCode;
import com.example.user.adapter.in.web.rest.dto.response.UserDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class LoginService implements LoginUseCase {

    private final LoadUserPort loadUserPort;

    private final TokenProvider tokenProvider;

    @Override
    public TokenResponse login(LoginRequest request) {

        UserDto userDto = loadUserPort.loadUser(request.getAccountId());

        if(!request.getPassword().equals(userDto.getPassword())){
           throw new BusinessException(ErrorCode.PASSWORD_MISMATCH);
        }

        return tokenProvider.generate(request.getAccountId());

    }
}
