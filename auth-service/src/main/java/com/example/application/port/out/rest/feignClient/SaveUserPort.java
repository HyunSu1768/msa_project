package com.example.application.port.out.rest.feignClient;

import com.example.adapter.in.web.rest.dto.request.SaveUserDto;

public interface SaveUserPort {

    void saveUser(SaveUserDto saveUserDto);

}
