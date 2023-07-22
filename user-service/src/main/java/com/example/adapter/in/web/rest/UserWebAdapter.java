package com.example.adapter.in.web.rest;

import com.example.common.annotation.WebAdapter;
import com.example.adapter.in.web.rest.dto.response.UserDto;
import com.example.application.port.in.LoadUserByAccountIdUseCase;
import com.example.application.port.in.LoadUserUseCase;
import com.example.application.port.in.SaveUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
@WebAdapter
public class UserWebAdapter {

    private final SaveUserUseCase saveUserUseCase;

    private final LoadUserUseCase loadUserUseCase;

    private final LoadUserByAccountIdUseCase loadUserByAccountIdUseCase;

    @GetMapping
    public UserDto loadUser(@RequestParam("userId") Long userId){

        return loadUserUseCase.loadUser(userId);

    }

    @GetMapping("/accountId")
    public UserDto loadUserByAccountId(@RequestParam("accountId") String accountId){

        return loadUserByAccountIdUseCase.loadUserByAccountId(accountId);

    }


}
