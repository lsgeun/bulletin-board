package com.example.postbackend.presentation.dto.response.practice;

public class SubPracticeResponseDto extends PracticeResponseDto {
    private final String subPractice;

    protected SubPracticeResponseDto(Builder<?> builder) {
        super(builder);
        this.subPractice = builder.subPractice;
    }

    public static Builder<?> builder() {
        return new Builder<>();
    }

    public String getSubPractice() {
        return this.subPractice;
    }

    public static class Builder<T extends Builder<T>> extends PracticeResponseDto.Builder<T> {
        private String subPractice;

        public T subPractice(String subPractice) {
            this.subPractice = subPractice;
            return self();
        }

        @Override
        protected T self() {
            return (T) this;
        }

        @Override
        public SubPracticeResponseDto build() {
            return new SubPracticeResponseDto(this);
        }
    }
}
