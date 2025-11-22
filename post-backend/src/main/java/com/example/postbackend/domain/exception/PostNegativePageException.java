package com.example.postbackend.domain.exception;

public class PostNegativePageException extends PostException {
    private final int page;

    public PostNegativePageException(int page) {
        super("페이지 번호가 1 이상이어야 합니다.");
        this.page = page;
    }

    public int getPage() {
        return this.page;
    }
}
