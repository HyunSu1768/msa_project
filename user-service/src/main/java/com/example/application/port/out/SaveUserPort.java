package com.example.application.port.out;

import com.example.adapter.in.web.rest.dto.request.SaveUserDto;
import com.example.domain.User;

public interface SaveUserPort {

    void saveUser(SaveUserDto saveUserDto);

}
