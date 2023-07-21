package com.example.auth.application.port.out.feignClient;

import com.example.user.adapter.in.web.rest.dto.request.SaveUserDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface SaveUserPort {

    void saveUser(@RequestBody SaveUserDto saveUserDto);

}
