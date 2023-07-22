package com.example.application.port.in;

import com.example.adapter.in.web.rest.dto.response.UserDto;

public interface LoadUserByAccountIdUseCase {

    UserDto loadUserByAccountId(String accountId);

}
