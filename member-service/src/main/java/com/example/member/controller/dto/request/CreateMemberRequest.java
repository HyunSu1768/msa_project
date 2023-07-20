package com.example.member.controller.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateUserRequest {

    private String accountId;

    private String password;

    private String name;

}
