package com.example.postbackend.presentation.dto.post.response;

import com.example.postbackend.presentation.dto.response.ResponseDto;

public class PostCreateResponseDto extends ResponseDto {
    private PostCreateResponseDto(PostCreateResponseDto.Builder builder) {
        super(builder);
    }

    public static class Builder extends ResponseDto.Builder<PostCreateResponseDto.Builder> {
        @Override
        protected PostCreateResponseDto.Builder self() {
            return this;
        }

        @Override
        public PostCreateResponseDto build() {
            return new PostCreateResponseDto(this);
        }
    }
}
