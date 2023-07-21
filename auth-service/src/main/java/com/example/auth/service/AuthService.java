package com.example.auth.service;

import com.example.auth.controller.dto.request.CreateMemberRequest;
import com.example.auth.controller.dto.request.LoginRequest;
import com.example.auth.controller.dto.response.MemberInfoResponse;
import com.example.auth.controller.dto.response.TokenResponse;
import com.example.auth.infra.MemberFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final MemberFeignClient memberFeignClient;

    private final TokenProvider tokenProvider;

    public void signup(CreateMemberRequest request){

        memberFeignClient.createMember(request);
    }

    public TokenResponse login(LoginRequest loginRequest) throws Exception {
        MemberInfoResponse memberInfoResponse = memberFeignClient.loadMemberByAccountId(loginRequest.getAccountId());

        if(!loginRequest.getPassword().equals(memberInfoResponse.getPassword())){
            throw new Exception("비밀번호가 다릅니다.");
        }

        return tokenProvider.generate(loginRequest.getAccountId());


    }

}
