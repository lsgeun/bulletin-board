package com.example.postbackend.domain.exception;

public class PostNoContentException extends PostException {
    private final int page;

    public PostNoContentException(int page) {
        super("컨텐츠가 존재하지 않습니다.");
        this.page = page;
    }

    public int getPage() {
        return page;
    }
}
