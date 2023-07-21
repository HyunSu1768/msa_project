package com.example.member.controller.dto.response;

import com.example.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberInfoResponse {

    private String name;

    private String accountId;

    private String password;

    public static MemberInfoResponse of(Member member){
        return MemberInfoResponse.builder()
                .password(member.getPassword())
                .accountId(member.getAccountId())
                .name(member.getName())
                .build();
    }

}
