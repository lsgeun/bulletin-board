package com.example.postbackend.presentation.dto.post.response;

public class PostItemResponseDto {
    private final Long id;
    private final String title;
    private final String content;

    protected PostItemResponseDto(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.content = builder.content;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
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

        public PostItemResponseDto build() {
            return new PostItemResponseDto(this);
        }
    }
}
