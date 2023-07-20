package com.example.member.service;

import com.example.member.controller.dto.request.CreateMemberRequest;
import com.example.member.controller.dto.response.MemberInfoResponse;
import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public void createUser(CreateMemberRequest request){

        Member member = Member.builder()
                .accountId(request.getAccountId())
                .name(request.getName())
                .password(request.getPassword())
                .build();

        memberRepository.save(member);

    }

    public MemberInfoResponse loadUser(Long memberId){

        Member member = memberRepository.findById(memberId).orElseThrow();

        return MemberInfoResponse.of(member);

    }

}
