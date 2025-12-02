package com.example.postbackend.presentation.dto.post.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostItemRequestDto {
    private final String title;
    private final String content;

    @JsonCreator
    public PostItemRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }
}
