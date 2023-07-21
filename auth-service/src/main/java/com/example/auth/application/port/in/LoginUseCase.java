package com.example.auth.application.port.in;

import com.example.auth.adapter.in.web.rest.dto.request.LoginRequest;
import com.example.auth.adapter.in.web.rest.dto.response.TokenResponse;

public interface LoginUseCase {

    TokenResponse login(LoginRequest request);

}
