package com.example.board.infra.feign;

import com.example.board.infra.feign.dto.MemberInfoResponse;
import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MEMBER-SERVICE")
public interface UserFeignClient {

    @GetMapping("/member")
    MemberInfoResponse loadUser(@RequestParam("memberId") Long memberId);

}
