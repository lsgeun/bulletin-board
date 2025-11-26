package com.example.postbackend.presentation.dto.post.response;

import com.example.postbackend.presentation.dto.response.ResponseDto;

public class PostDeleteResponseDto extends ResponseDto {
    private PostDeleteResponseDto(Builder builder) {
        super(builder);
    }

    public static class Builder extends ResponseDto.Builder<Builder> {
        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public PostDeleteResponseDto build() {
            return new PostDeleteResponseDto(this);
        }
    }
}
