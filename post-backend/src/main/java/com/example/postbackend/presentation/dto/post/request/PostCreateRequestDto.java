package com.example.postbackend.presentation.dto.post.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostCreateRequestDto {
    private final PostItemRequestDto post;

    @JsonCreator
    public PostCreateRequestDto(@JsonProperty("title") String title, @JsonProperty("content") String content) {
        this.post = new PostItemRequestDto(title, content);
    }

    public PostItemRequestDto getPost() {
        return this.post;
    }
}
