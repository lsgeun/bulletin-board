package com.example.postbackend.domain.post.exception;

import lombok.Getter;

@Getter
public class PostPageOutOfRangeException extends PostException {
    private final Integer page;

    public PostPageOutOfRangeException(Integer page) {
        super("요청한 페이지를 불러올 수 없습니다. 다시 시도해주세요.", "POST_PAGE_OUT_OF_RANGE");
        this.page = page;
    }
}
