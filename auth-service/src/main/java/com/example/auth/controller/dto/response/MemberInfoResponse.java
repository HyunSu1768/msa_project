package com.example.auth.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberInfoResponse {

    private String name;

    private String accountId;

    private String password;

}
