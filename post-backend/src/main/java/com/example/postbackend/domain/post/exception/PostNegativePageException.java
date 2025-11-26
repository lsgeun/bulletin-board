package com.example.postbackend.domain.post.exception;

public class PostNegativePageException extends PostException {
    private final Integer page;

    public PostNegativePageException(Integer page) {
        super("요청한 페이지를 불러올 수 없습니다. 다시 시도해주세요.", "POST_NEGATIVE_PAGE");
        this.page = page;
    }

    public Integer getPage() {
        return this.page;
    }
}
