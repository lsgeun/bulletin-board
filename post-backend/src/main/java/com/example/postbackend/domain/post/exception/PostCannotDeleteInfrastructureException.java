package com.example.postbackend.domain.post.exception;

import com.example.postbackend.domain.exception.InfrastructureException;

public class PostCannotDeleteInfrastructureException extends InfrastructureException {
    private final Long id;
    public PostCannotDeleteInfrastructureException(Long id) {
        super("게시글이 존재함에도 삭제할 수 없음");
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
