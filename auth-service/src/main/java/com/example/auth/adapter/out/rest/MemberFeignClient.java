package com.example.auth.adapter.out.rest;

import com.example.auth.application.port.out.feignClient.UserFeignPort;
import com.example.user.adapter.in.web.rest.dto.request.SaveUserDto;
import com.example.user.adapter.in.web.rest.dto.response.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MEMBER-SERVICE")
public interface MemberFeignClient extends UserFeignPort {

    @PostMapping("/user")
    public void createMember(@RequestBody SaveUserDto request);

    @GetMapping("/user/accountId")
    public UserDto loadMemberByAccountId(@RequestParam("accountId") String accountId);

}
