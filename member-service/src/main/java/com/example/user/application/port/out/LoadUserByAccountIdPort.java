package com.example.user.application.port.out;

import com.example.user.adapter.in.web.rest.dto.response.UserDto;

public interface LoadUserByAccountIdPort {

    UserDto loadUserByAccountId(String accountId);

}
