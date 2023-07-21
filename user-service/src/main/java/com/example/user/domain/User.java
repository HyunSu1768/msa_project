package com.example.user.domain;

import com.example.user.adapter.in.web.rest.dto.response.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tbl_member")
public class User {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "account_id", nullable = false)
    private String accountId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name")
    private String name;

    public UserDto toDto(){
        return UserDto.of(this);
    }

}
