package com.example.postbackend.domain.post.exception;

import com.example.postbackend.domain.exception.DomainException;

public abstract class PostException extends DomainException {
    protected PostException(String message, String errorCode) {
        super(message, errorCode);
    }

    protected PostException(String message, Throwable cause, String errorCode) {
        super(message, cause, errorCode);
    }
}
