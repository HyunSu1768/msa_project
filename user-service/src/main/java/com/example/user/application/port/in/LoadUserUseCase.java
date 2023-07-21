package com.example.user.application.port.in;

import com.example.user.adapter.in.web.rest.dto.response.UserDto;

public interface LoadUserUseCase {

    UserDto loadUser(Long userId);

}
