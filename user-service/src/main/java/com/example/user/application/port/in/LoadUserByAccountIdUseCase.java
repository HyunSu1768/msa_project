package com.example.user.application.port.in;

import com.example.user.adapter.in.web.rest.dto.response.UserDto;

public interface LoadUserByAccountIdUseCase {

    UserDto loadUserByAccountId(String accountId);

}
