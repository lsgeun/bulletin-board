package com.example.postbackend.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseResponseDto {
    private String code;
    private String message;

    protected BaseResponseDto(Builder<?> builder) {
        this.code = builder.code;
        this.message = builder.message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public static abstract class Builder<T extends Builder<T>> {
        private String code;
        private String message;

        public T code(String code) {
            this.code = code;
            return self();
        }

        public T message(String message) {
            this.message = message;
            return self();
        }

        protected abstract T self();

        public abstract BaseResponseDto build();
    }
}
