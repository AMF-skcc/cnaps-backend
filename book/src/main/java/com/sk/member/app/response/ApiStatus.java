package com.sk.member.app.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

/**
 * Book Service의 오류코드는 200으로 시작함
 */
@Getter
public enum ApiStatus {

    UNEXPECTED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, -200, "unexpected error for book service"),
    ;

    private final HttpStatus httpStatus;
    private final Integer code;
    private final String message;

    ApiStatus(HttpStatus httpStatus, Integer code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public static ApiStatus of(String message) {
        return Arrays.stream(ApiStatus.values())
                .filter(apiStatus -> apiStatus.getMessage().equals(message))
                .findFirst()
                .orElse(null);
    }
}
