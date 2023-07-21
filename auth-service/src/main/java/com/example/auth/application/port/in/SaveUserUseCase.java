package com.example.auth.application.port.in;

import com.example.user.adapter.in.web.rest.dto.request.SaveUserDto;

public interface SaveUserUseCase {

    void saveUser(SaveUserDto dto);

}
