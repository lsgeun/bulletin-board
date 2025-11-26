package com.example.postbackend.presentation.dto.post.response;

import com.example.postbackend.domain.post.Post;
import com.example.postbackend.presentation.dto.response.ResponseDto;

public class PostReadResponseDto extends ResponseDto {
    private Long id;
    private String title;
    private String content;

    private PostReadResponseDto(Builder builder) {
        super(builder);
        this.id = builder.id;
        this.title = builder.title;
        this.content = builder.content;
    }

    public static PostReadResponseDto.Builder from(Post post) {
        return new Builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public static class Builder extends ResponseDto.Builder<Builder> {
        private Long id;
        private String title;
        private String content;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
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
