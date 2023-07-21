package com.example.auth.controller;

import com.example.auth.controller.dto.request.CreateMemberRequest;
import com.example.auth.controller.dto.request.LoginRequest;
import com.example.auth.controller.dto.response.TokenResponse;
import com.example.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/signup")
    public void signup(@RequestBody CreateMemberRequest request){
        authService.signup(request);
    }

    @PostMapping("/auth/login")
    public TokenResponse login(@RequestBody LoginRequest request) throws Exception {
        return authService.login(request);
    }

}
