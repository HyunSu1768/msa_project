package com.example.application.port.out.rest.feignClient;

import com.example.adapter.in.web.rest.dto.response.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface LoadUserPort {

    @GetMapping("/user/accountId")
    UserDto loadUser(@RequestParam String accountId);
}
