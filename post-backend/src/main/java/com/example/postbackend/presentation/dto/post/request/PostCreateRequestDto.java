package com.example.postbackend.presentation.dto.post.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostCreateRequestDto {
    private final String title;
    private final String content;

    @JsonCreator
    public PostCreateRequestDto(@JsonProperty("title") String title, @JsonProperty("content") String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
