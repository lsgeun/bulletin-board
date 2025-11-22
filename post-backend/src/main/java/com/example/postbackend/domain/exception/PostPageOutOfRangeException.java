package com.example.postbackend.domain.exception;

public class PostPageOutOfRangeException extends PostException {
    private final int page;

    public PostPageOutOfRangeException(int page) {
        super("요청한 페이지가 범위를 벗어났습니다.");
        this.page = page;
    }

    public int getPage() {
        return page;
    }
}
