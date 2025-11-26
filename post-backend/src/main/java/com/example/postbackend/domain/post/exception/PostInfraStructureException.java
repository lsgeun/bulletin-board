package com.example.postbackend.domain.post.exception;

import com.example.postbackend.domain.exception.InfrastructureException;

public abstract class PostInfraStructureException extends InfrastructureException {
    protected PostInfraStructureException(String message, String errorCode) {
        super(message, errorCode);
    }

    protected PostInfraStructureException(String message, Throwable cause, String errorCode) {
        super(message, cause, errorCode);
    }
}
