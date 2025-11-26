package com.example.postbackend.domain.exception;

public abstract class DomainException extends BaseException {
    protected DomainException(String message, String errorCode) {
        super(message, errorCode);
    }

    protected DomainException(String message, Throwable cause, String errorCode) {
        super(message, cause, errorCode);
    }
}
