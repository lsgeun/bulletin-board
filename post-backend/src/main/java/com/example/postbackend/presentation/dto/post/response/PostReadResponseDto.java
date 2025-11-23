package com.example.postbackend.presentation.dto.post.response;

import com.example.postbackend.domain.post.Post;

public class PostReadResponseDto {
    private Long id;
    private String title;
    private String content;

    PostReadResponseDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
    
    public static PostReadResponseDto toDto(Post post) {
        return new PostReadResponseDto(post.getId(), post.getTitle(), post. getContent());
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
