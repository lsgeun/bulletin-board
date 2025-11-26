package com.example.postbackend.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ResponseDto {
    private String errorCode;
    private String message;

    protected ResponseDto(Builder<?> builder) {
        this.errorCode = builder.errorCode;
        this.message = builder.message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public static abstract class Builder<T extends Builder<T>> {
        private String errorCode;
        private String message;

        public T errorCode(String errorCode) {
            this.errorCode = errorCode;
            return self();
        }

        public T message(String message) {
            this.message = message;
            return self();
        }

        protected abstract T self();

        public abstract ResponseDto build();
    }
}
