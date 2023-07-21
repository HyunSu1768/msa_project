package com.example.member.controller;

import com.example.member.controller.dto.request.CreateMemberRequest;
import com.example.member.controller.dto.response.MemberInfoResponse;
import com.example.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/member")
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public void createMember(@RequestBody CreateMemberRequest request){

        memberService.createMember(request);

    }

    @GetMapping
    public MemberInfoResponse loadMember(@RequestParam("memberId") Long memberId){

        return memberService.loadMemer(memberId);
    }

    @GetMapping("/accountId")
    public MemberInfoResponse loadMemberByAccountId(@RequestParam("accountId") String accountId){

        return memberService.loadMemberByAccountId(accountId);

    }


}
