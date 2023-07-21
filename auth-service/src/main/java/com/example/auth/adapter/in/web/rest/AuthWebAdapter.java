package com.example.auth.adapter.in.web.rest;

import com.example.auth.adapter.in.web.rest.dto.request.LoginRequest;
import com.example.auth.adapter.in.web.rest.dto.response.TokenResponse;
import com.example.auth.application.port.in.LoginUseCase;
import com.example.auth.application.port.in.SaveUserUseCase;
import com.example.common.annotation.WebAdapter;
import com.example.user.adapter.in.web.rest.dto.request.SaveUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@WebAdapter
public class AuthWebAdapter {

    private final SaveUserUseCase saveUserUseCase;

    private final LoginUseCase loginUseCase;

    @PostMapping("/auth/signup")
    public void signup(@RequestBody SaveUserDto request){
        saveUserUseCase.saveUser(request);
    }

    @PostMapping("/auth/login")
    public TokenResponse login(@RequestBody LoginRequest request) {
        return loginUseCase.login(request);
    }

}
