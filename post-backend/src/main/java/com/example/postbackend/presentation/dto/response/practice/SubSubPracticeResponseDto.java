package com.example.postbackend.presentation.dto.response.practice;

public class SubSubPracticeResponseDto extends SubPracticeResponseDto {
    private final String subSubPractice;

    protected SubSubPracticeResponseDto(Builder builder) {
        super(builder);
        this.subSubPractice = builder.subSubPractice;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getSubSubPractice() {
        return this.subSubPractice;
    }

    public static class Builder extends SubPracticeResponseDto.Builder<Builder> {
        private String subSubPractice;

        public Builder subSubPractice(String subSubPractice) {
            this.subSubPractice = subSubPractice;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public SubSubPracticeResponseDto build() {
            return new SubSubPracticeResponseDto(this);
        }
    }
}
