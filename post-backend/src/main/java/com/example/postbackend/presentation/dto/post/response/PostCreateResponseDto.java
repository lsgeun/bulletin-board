package com.example.postbackend.presentation.dto.post.response;

import com.example.postbackend.presentation.dto.response.BaseResponseDto;

public class PostCreateResponseDto extends BaseResponseDto {
    private PostCreateResponseDto(Builder builder) {
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
        public PostCreateResponseDto build() {
            return new PostCreateResponseDto(this);
        }
    }
}
