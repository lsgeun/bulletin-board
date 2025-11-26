package com.example.postbackend.domain.exception;

public abstract class InfrastructureException extends BaseException {
    protected InfrastructureException(String message, String errorCode) {
        super(message, errorCode);
    }

    protected InfrastructureException(String message, Throwable cause, String errorCode) {
        super(message, cause, errorCode);
    }
}
