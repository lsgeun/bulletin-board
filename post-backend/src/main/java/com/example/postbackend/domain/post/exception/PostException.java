package com.example.postbackend.domain.post.exception;

import com.example.postbackend.domain.exception.DomainException;

public abstract class PostException extends DomainException {
    protected PostException(String message) {
        super(message);
    }

    protected PostException(String message, Throwable cause) {
        super(message, cause);
    }
}
