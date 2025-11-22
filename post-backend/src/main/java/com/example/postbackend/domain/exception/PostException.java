package com.example.postbackend.domain.exception;

public abstract class PostException extends DomainException {
    protected PostException(String message) {
        super(message);
    }

    protected PostException(String message, Throwable cause) {
        super(message, cause);
    }
}
