package com.example.user.adapter.in.web.rest.dto.response;

import com.example.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDto {

    private String name;

    private String accountId;

    private String password;

    public static UserDto of(User user){
        return UserDto.builder()
                .password(user.getPassword())
                .accountId(user.getAccountId())
                .name(user.getName())
                .build();
    }

}
