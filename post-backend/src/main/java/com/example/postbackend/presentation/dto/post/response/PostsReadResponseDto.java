package com.example.postbackend.presentation.dto.post.response;

import com.example.postbackend.domain.post.Post;
import com.example.postbackend.presentation.dto.response.BaseResponseDto;

import java.util.List;

public class PostsReadResponseDto extends BaseResponseDto {
    private List<PostItemResponseDto> posts;
    private Integer page;

    private PostsReadResponseDto(Builder builder) {
        super(builder);
        this.posts = builder.posts;
        this.page = builder.page;
    }

    public List<PostItemResponseDto> getPosts() {
        return this.posts;
    }

    public Integer getPage() {
        return this.page;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends BaseResponseDto.Builder<Builder> {
        private List<PostItemResponseDto> posts;
        private Integer page;

        public Builder posts(List<PostItemResponseDto> posts) {
            this.posts = posts;
            return this;
        }

        public Builder page(Integer page) {
            this.page = page;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public PostsReadResponseDto build() {
            return new PostsReadResponseDto(this);
        }
    }
}
