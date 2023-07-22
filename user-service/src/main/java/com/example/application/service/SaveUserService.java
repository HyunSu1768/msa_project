package com.example.application.service;

import com.example.common.annotation.UseCase;
import com.example.adapter.in.web.rest.dto.request.SaveUserDto;
import com.example.application.port.in.SaveUserUseCase;
import com.example.application.port.out.SaveUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class SaveUserService implements SaveUserUseCase {

    private final SaveUserPort saveUserPort;

    @Override
    public void saveUser(SaveUserDto dto) {

        saveUserPort.saveUser(dto);

    }

}
