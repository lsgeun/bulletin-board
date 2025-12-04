package com.example.postbackend.domain.post.exception;

import lombok.Getter;

@Getter
public class PostNoContentException extends PostException {
    private final Integer page;

    public PostNoContentException(Integer page) {
        super("게시글이 존재하지 않습니다.", "POST_NO_CONTENT");
        this.page = page;
    }
}
