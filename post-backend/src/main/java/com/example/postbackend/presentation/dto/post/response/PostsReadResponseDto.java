package com.example.postbackend.presentation.dto.post.response;

import com.example.postbackend.domain.post.Post;
import com.example.postbackend.presentation.dto.response.ResponseDto;

import java.util.List;

public class PostsReadResponseDto extends ResponseDto {
    private List<Post> posts;
    private Integer page;

    private PostsReadResponseDto(Builder builder) {
        super(builder);
        this.posts = builder.posts;
        this.page = builder.page;
    }

    public static Builder from(List<Post> posts) {
        return new Builder()
                .posts(posts);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Integer getPage() {
        return page;
    }

    public static class Builder extends ResponseDto.Builder<Builder> {
        private List<Post> posts;
        private Integer page;

        public Builder page(Integer page) {
            this.page = page;
            return this;
        }

        public Builder posts(List<Post> posts) {
            this.posts = posts;
            return this;
        }

        protected Builder self() {
            return this;
        }

        public PostsReadResponseDto build() {
            return new PostsReadResponseDto(this);
        }
    }
}
