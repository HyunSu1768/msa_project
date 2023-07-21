package com.example.auth.application.port.out.feignClient;

import com.example.user.adapter.in.web.rest.dto.response.UserDto;
import org.springframework.web.bind.annotation.RequestParam;

public interface LoadUserPort {

    UserDto loadUser(@RequestParam String accountId);
}
