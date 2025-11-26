package com.example.postbackend.presentation.dto.post.response.error;

import com.example.postbackend.presentation.dto.response.ResponseDto;

public class PostErrorResponseDto extends ResponseDto {
    protected PostErrorResponseDto(Builder builder) {
        super(builder);
    }

    public static class Builder extends ResponseDto.Builder<Builder> {
        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public PostErrorResponseDto build() {
            return new PostErrorResponseDto(this);
        }
    }
}
