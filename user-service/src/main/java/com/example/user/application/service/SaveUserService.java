package com.example.user.application.service;

import com.example.common.annotation.UseCase;
import com.example.user.adapter.in.web.rest.dto.request.SaveUserDto;
import com.example.user.application.port.in.SaveUserUseCase;
import com.example.user.application.port.out.SaveUserPort;
import com.example.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class SaveUserService implements SaveUserUseCase {

    private final SaveUserPort saveUserPort;

    @Override
    public void saveUserPort(SaveUserDto dto) {

        saveUserPort.saveUser(dto);

    }

}
