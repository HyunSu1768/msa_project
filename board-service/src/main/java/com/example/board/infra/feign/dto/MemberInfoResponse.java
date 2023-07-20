package com.example.member.controller.dto.response;

import com.example.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberInfoResponse {

    private String name;

    private String accountId;

    public static MemberInfoResponse of(Member member){
        return MemberInfoResponse.builder()
                .accountId(member.getAccountId())
                .name(member.getName())
                .build();
    }

}
