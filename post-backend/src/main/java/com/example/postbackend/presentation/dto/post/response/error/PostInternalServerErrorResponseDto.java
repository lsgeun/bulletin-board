package com.example.postbackend.presentation.dto.post.response.error;

import com.example.postbackend.presentation.dto.response.BaseResponseDto;

public class PostInternalServerErrorResponseDto extends BaseResponseDto {
    protected PostInternalServerErrorResponseDto(Builder builder) {
        super(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends BaseResponseDto.Builder<Builder> {
        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public PostInternalServerErrorResponseDto build() {
            return new PostInternalServerErrorResponseDto(this);
        }
    }
}
