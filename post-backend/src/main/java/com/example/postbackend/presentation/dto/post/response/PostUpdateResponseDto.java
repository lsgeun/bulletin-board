package com.example.postbackend.presentation.dto.post.response;

import com.example.postbackend.presentation.dto.response.BaseResponseDto;

public class PostUpdateResponseDto extends BaseResponseDto {
    private PostUpdateResponseDto(Builder builder) {
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
        public PostUpdateResponseDto build() {
            return new PostUpdateResponseDto(this);
        }
    }
}
