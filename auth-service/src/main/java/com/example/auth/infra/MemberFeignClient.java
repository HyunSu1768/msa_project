package com.example.auth.infra;

import com.example.auth.controller.dto.request.CreateMemberRequest;
import com.example.auth.controller.dto.response.MemberInfoResponse;
import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MEMBER-SERVICE")
public interface MemberFeignClient {

    @PostMapping("/member")
    public void createMember(@RequestBody CreateMemberRequest request);

    @GetMapping("/member/accountId")
    public MemberInfoResponse loadMemberByAccountId(@RequestParam("accountId") String accountId);

}
