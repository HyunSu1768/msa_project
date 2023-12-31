package com.example.adapter.out.rest.feign;

import com.example.application.port.out.feignPort.UserFeignPort;
import com.example.adapter.in.web.rest.dto.response.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MEMBER-SERVICE")
public interface UserFeignClient extends UserFeignPort {

    @GetMapping("/user")
    UserDto loadUser(@RequestParam("memberId") Long memberId);

}
