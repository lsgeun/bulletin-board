package com.example.postbackend.domain.post.exception;

public class PostNoContentException extends PostException {
    private final Integer page;

    public PostNoContentException(Integer page) {
        super("게시글이 존재하지 않습니다.", "POST_NO_CONTENT");
        this.page = page;
    }

    public Integer getPage() {
        return page;
    }
}
