package com.example.board.infra.feign.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberInfoResponse {

    private String name;

    private String accountId;

}
