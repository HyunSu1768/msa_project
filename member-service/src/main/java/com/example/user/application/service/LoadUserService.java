package com.example.user.application.service;

import com.example.common.annotation.UseCase;
import com.example.user.adapter.in.web.rest.dto.response.UserDto;
import com.example.user.application.port.in.LoadUserUseCase;
import com.example.user.application.port.out.LoadUserPort;
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
