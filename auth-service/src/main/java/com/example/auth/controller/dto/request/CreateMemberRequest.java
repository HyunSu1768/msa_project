package com.example.auth.controller.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateMemberRequest {

    private String accountId;

    private String password;

    private String name;

}
