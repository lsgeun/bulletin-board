package com.example.postbackend.presentation.dto.response.practice;

public class PracticeResponseDto extends com.example.postbackend.presentation.dto.response.BaseResponseDto {
    private final String practice;

    protected PracticeResponseDto(Builder<?> builder) {
        super(builder);
        this.practice = builder.practice;
    }

    public String getPractice() {
        return this.practice;
    }

    public static Builder<?> builder() {
        return new Builder<>();
    }

    public static class Builder<T extends Builder<T>> extends com.example.postbackend.presentation.dto.response.BaseResponseDto.Builder<T> {
        private String practice;

        public T practice(String practice) {
            this.practice = practice;
            return self();
        }

        @Override
        protected T self() {
            return (T) this;
        }

        @Override
        public PracticeResponseDto build() {
            return new PracticeResponseDto(this);
        }
    }
}
