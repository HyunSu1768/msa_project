package com.example.user.adapter.in.web.rest;

import com.example.common.annotation.WebAdapter;
import com.example.user.adapter.in.web.rest.dto.request.SaveUserDto;
import com.example.user.adapter.in.web.rest.dto.response.UserDto;
import com.example.user.application.port.in.LoadUserByAccountIdUseCase;
import com.example.user.application.port.in.LoadUserUseCase;
import com.example.user.application.port.in.SaveUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/user")
@RequiredArgsConstructor
@WebAdapter
public class UserWebAdapter {

    private final SaveUserUseCase saveUserUseCase;

    private final LoadUserUseCase loadUserUseCase;

    private final LoadUserByAccountIdUseCase loadUserByAccountIdUseCase;

    @PostMapping
    public void createUser(@RequestBody SaveUserDto request){

        saveUserUseCase.saveUserPort(request);

    }

    @GetMapping
    public UserDto loadUser(@RequestParam("userId") Long userId){

        return loadUserUseCase.loadUser(userId);

    }

    @GetMapping("/accountId")
    public UserDto loadUserByAccountId(@RequestParam("accountId") String accountId){

        return loadUserByAccountIdUseCase.loadUserByAccountId(accountId);

    }


}