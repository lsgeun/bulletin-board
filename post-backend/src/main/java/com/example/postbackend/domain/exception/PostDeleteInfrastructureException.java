package com.example.postbackend.domain.exception;

public class PostDeleteInfrastructureException extends InfrastructureException {
    private final Long id;

    public PostDeleteInfrastructureException(Long id, Throwable cause) {
        super("게시물 삭제 과정에서 에러가 발생했습니다.", cause);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
