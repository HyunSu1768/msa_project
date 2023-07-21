package com.example.board.application.port.out.feignPort;

import com.example.user.adapter.in.web.rest.dto.response.UserDto;

public interface LoadUserPort {

    UserDto loadUser(Long userId);

}
