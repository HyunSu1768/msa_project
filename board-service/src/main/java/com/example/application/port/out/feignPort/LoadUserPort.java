package com.example.application.port.out.feignPort;

import com.example.adapter.in.web.rest.dto.response.UserDto;

public interface LoadUserPort {

    UserDto loadUser(Long userId);

}
