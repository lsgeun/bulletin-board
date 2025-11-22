package com.example.postbackend.domain.exception;

public class PostNotFoundException extends PostException {
    private final Long id;

    public PostNotFoundException(Long id) {
        super("Post 값을 찾지 못했습니다.");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
