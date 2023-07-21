package com.example.user.application.port.in;

import com.example.user.adapter.in.web.rest.dto.request.SaveUserDto;

public interface SaveUserUseCase {

    void saveUserPort(SaveUserDto request);

}
