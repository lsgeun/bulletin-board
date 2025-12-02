package com.example.postbackend.domain.post.exception;

public class PostDeleteFailureInfrastructureException extends PostInfraStructureException {
    private final Long id;

    public PostDeleteFailureInfrastructureException(Long id, Throwable cause) {
        super("게시물 삭제에 실패했습니다. 다시 시도해주세요.", cause, "POST_DELETE_FAILURE");
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
