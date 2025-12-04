package com.example.postbackend.domain.post.exception;

import lombok.Getter;

@Getter
public class PostNotFoundException extends PostException {
    private final Long id;

    public PostNotFoundException(Long id) {
        super("요청한 게시글을 찾을 수 없습니다.", "POST_NOT_FOUND");
        this.id = id;
    }
}
