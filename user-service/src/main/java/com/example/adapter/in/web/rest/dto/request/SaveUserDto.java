package com.example.adapter.in.web.rest.dto.request;

import com.example.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaveUserDto {

    private String accountId;

    private String password;

    private String name;

    public User toUser(){
        return User.builder()
                .name(this.getName())
                .accountId(this.getAccountId())
                .password(this.getPassword())
                .build();
    }

}
