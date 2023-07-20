package com.example.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.naming.Name;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tbl_member")
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "account_id", nullable = false)
    private String accountId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name")
    private String name;

}
