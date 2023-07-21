package com.example.auth.application.service;

import com.example.auth.application.port.in.SaveUserUseCase;
import com.example.auth.application.port.out.feignClient.SaveUserPort;
import com.example.auth.application.port.out.feignClient.UserFeignPort;
import com.example.common.annotation.UseCase;
import com.example.user.adapter.in.web.rest.dto.request.SaveUserDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class SaveUserService implements SaveUserUseCase {

    private final SaveUserPort saveUserPort;

    @Override
    public void saveUser(SaveUserDto dto) {

        saveUserPort.saveUser(dto);

    }

}
