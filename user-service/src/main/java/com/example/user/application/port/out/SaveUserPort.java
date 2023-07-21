package com.example.user.application.port.out;

import com.example.user.adapter.in.web.rest.dto.request.SaveUserDto;
import com.example.user.domain.User;

public interface SaveUserPort {

    void saveUser(SaveUserDto saveUserDto);

}
