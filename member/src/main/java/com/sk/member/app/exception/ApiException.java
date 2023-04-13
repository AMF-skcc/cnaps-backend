package com.sk.member.app.exception;

import com.sk.member.app.response.ApiStatus;
import lombok.Getter;

public class ApiException extends RuntimeException {
    @Getter
    private ApiStatus apiStatus;

    public ApiException(ApiStatus apiStatus) {
        super(apiStatus.getMessage());
        this.apiStatus = apiStatus;
    }

    public ApiException(String apiStatus) {
        super(apiStatus);
    }
}
