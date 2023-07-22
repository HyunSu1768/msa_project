package com.example.adapter.in.web.rest;

import com.example.adapter.in.web.rest.dto.request.LoginRequest;
import com.example.adapter.in.web.rest.dto.response.TokenResponse;
import com.example.application.port.in.LoginUseCase;
import com.example.application.port.in.UserSignupUseCase;
import com.example.common.annotation.WebAdapter;
import com.example.adapter.in.web.rest.dto.request.SaveUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@WebAdapter
public class AuthWebAdapter {

    private final UserSignupUseCase userSignupUseCase;

    private final LoginUseCase loginUseCase;

    @PostMapping("/auth/signup")
    public void signup(@RequestBody SaveUserDto request){
        userSignupUseCase.saveUser(request);
    }

    @PostMapping("/auth/login")
    public TokenResponse login(@RequestBody LoginRequest request) {
        return loginUseCase.login(request);
    }

}
