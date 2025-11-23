package com.example.postbackend.presentation.dto.post.response;

import com.example.postbackend.domain.post.Post;

import java.util.List;

public class PostsReadResponseDto {
    private List<Post> posts;
    private String message;
    private int page;

    public PostsReadResponseDto(List<Post> posts, String message, int page) {
        this.posts = posts;
        this.message = message;
        this.page = page;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public String getMessage() {
        return message;
    }

    public int getPage() {
        return page;
    }
}
