package com.example.application.service;

import com.example.application.port.in.UserSignupUseCase;
import com.example.application.port.out.rest.feignClient.SaveUserPort;
import com.example.common.annotation.UseCase;
import com.example.adapter.in.web.rest.dto.request.SaveUserDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class Signup implements UserSignupUseCase {

    private final SaveUserPort saveUserPort;

    @Override
    public void saveUser(SaveUserDto dto) {

        saveUserPort.saveUser(dto);

    }

}
