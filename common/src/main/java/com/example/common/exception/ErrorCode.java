package com.example.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    TOKEN_NEED_ERROR(401, "토큰이 필요합니다."),
    INVALID_TOKEN_ERROR(401, "올바르지 않은 토큰입니다."),
    EXPIRED_TOKEN_ERROR(401, "토큰이 만료되었습니다."),
    USER_NOT_FOUND(404, "찾을 수 없는 유저입니다."),

    PASSWORD_MISMATCH(400, "비밀번호가 일치하지 않습니다.");

    private final int statusCode;

    private final String message;



}
