package com.example.postbackend.domain.post.exception;

import com.example.postbackend.domain.exception.InfrastructureException;

public class PostCannotDeleteExistingInfrastructureException extends InfrastructureException {
    private final Long id;
    public PostCannotDeleteExistingInfrastructureException(Long id, Throwable cause) {
        // 게시글이 존재함에도 삭제할 수 없음
        super("게시물 삭제에 실패했습니다. 다시 시도해주세요.", cause, "POST_CANNOT_DELETE_EXISTING");
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
