package com.example.postbackend.presentation.dto.post.response;

import com.example.postbackend.presentation.dto.response.BaseResponseDto;

public class PostReadResponseDto extends BaseResponseDto {
    private PostItemResponseDto post;

    private PostReadResponseDto(Builder builder) {
        super(builder);
        this.post = builder.post;
    }

    public PostItemResponseDto getPost() {
        return this.post;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends BaseResponseDto.Builder<Builder> {
        private PostItemResponseDto post;

        public Builder post(PostItemResponseDto post) {
            this.post = post;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public PostReadResponseDto build() {
            return new PostReadResponseDto(this);
        }
    }
}
