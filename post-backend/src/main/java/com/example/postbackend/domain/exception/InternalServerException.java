package com.example.postbackend.domain.exception;

public class InternalServerException extends BaseException {
    public InternalServerException(Throwable cause) {
        super("서버 내부 에러", cause, "INTERNAL_SERVER_ERROR");
    }
}
