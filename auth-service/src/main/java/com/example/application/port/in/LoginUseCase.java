package com.example.application.port.in;

import com.example.adapter.in.web.rest.dto.request.LoginRequest;
import com.example.adapter.in.web.rest.dto.response.TokenResponse;

public interface LoginUseCase {

    TokenResponse login(LoginRequest request);

}
