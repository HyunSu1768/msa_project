package com.example.application.service;

import com.example.common.annotation.UseCase;
import com.example.adapter.in.web.rest.dto.response.UserDto;
import com.example.application.port.in.LoadUserUseCase;
import com.example.application.port.out.LoadUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class LoadUserService implements LoadUserUseCase {

    private final LoadUserPort loadUserPort;

    @Override
    public UserDto loadUser(Long userId) {
        return loadUserPort.loadUser(userId);
    }

}
