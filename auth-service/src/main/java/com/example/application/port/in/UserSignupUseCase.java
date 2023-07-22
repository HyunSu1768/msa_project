package com.example.application.port.in;

import com.example.adapter.in.web.rest.dto.request.SaveUserDto;

public interface UserSignupUseCase {

    void saveUser(SaveUserDto dto);

}
