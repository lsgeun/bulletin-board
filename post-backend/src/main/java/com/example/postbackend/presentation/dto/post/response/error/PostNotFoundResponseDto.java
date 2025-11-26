package com.example.postbackend.presentation.dto.post.response.error;

import com.example.postbackend.presentation.dto.response.ResponseDto;

public class PostNotFoundResponseDto extends ResponseDto {
    private Long id;

    protected PostNotFoundResponseDto(Builder builder) {
        super(builder);
        this.id = builder.id;
    }

    public Long getId() {
        return id;
    }

    public static class Builder extends ResponseDto.Builder<Builder> {
        private Long id;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public PostNotFoundResponseDto build() {
            return new PostNotFoundResponseDto(this);
        }
    }
}
