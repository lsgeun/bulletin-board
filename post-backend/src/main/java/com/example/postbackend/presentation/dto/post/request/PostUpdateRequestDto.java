package com.example.postbackend.presentation.dto.post.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class PostUpdateRequestDto {
    private final Long id;
    private final String title;
    private final String content;

    @JsonCreator
    public PostUpdateRequestDto(@JsonProperty("id") Long id, @JsonProperty("title") String title, @JsonProperty("content") String content) {
        this.id = id;
        this.title = title;
        this.content = content;
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
}
