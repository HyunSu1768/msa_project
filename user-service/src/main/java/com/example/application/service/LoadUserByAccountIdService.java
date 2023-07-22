package com.example.application.service;

import com.example.common.annotation.UseCase;
import com.example.adapter.in.web.rest.dto.response.UserDto;
import com.example.application.port.in.LoadUserByAccountIdUseCase;
import com.example.application.port.out.LoadUserByAccountIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class LoadUserByAccountIdService implements LoadUserByAccountIdUseCase {

    private final LoadUserByAccountIdPort loadUserByAccountIdPort;

    @Override
    public UserDto loadUserByAccountId(String accountId) {
        return loadUserByAccountIdPort.loadUserByAccountId(accountId);
    }
}
