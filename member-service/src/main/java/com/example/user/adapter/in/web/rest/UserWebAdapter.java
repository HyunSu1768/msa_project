package com.example.user.adapter.in.web.rest;

import com.example.common.annotation.WebAdapter;
import com.example.user.adapter.in.web.rest.dto.request.SaveUserDto;
import com.example.user.adapter.in.web.rest.dto.response.UserInfoResponse;
import com.example.user.application.port.in.SaveUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RequestMapping("/member")
@RequiredArgsConstructor
@RestController
public class UserWebAdapter {

    private final SaveUserUseCase saveUserUseCase;

    @PostMapping
    public void createUser(@RequestBody SaveUserDto request){

        saveUserUseCase.saveUserPort(request);

    }

    @GetMapping
    public UserInfoResponse loadUser(@RequestParam("memberId") Long memberId){

    }

    @GetMapping("/accountId")
    public UserInfoResponse loadUserByAccountId(@RequestParam("accountId") String accountId){


    }


}
