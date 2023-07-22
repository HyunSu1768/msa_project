package com.example.adapter.out.rest;

import com.example.application.port.out.rest.feignClient.UserFeignPort;
import com.example.adapter.in.web.rest.dto.response.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MEMBER-SERVICE")
public interface MemberFeignClient extends UserFeignPort {

    @GetMapping("/user/accountId")
    UserDto loadMemberByAccountId(@RequestParam("accountId") String accountId);

}
