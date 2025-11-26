package com.example.postbackend.presentation.exception;

import com.example.postbackend.domain.exception.InternalServerException;
import com.example.postbackend.domain.post.exception.*;
import com.example.postbackend.presentation.dto.post.response.error.PostErrorResponseDto;
import com.example.postbackend.presentation.dto.post.response.PostDeleteResponseDto;
import com.example.postbackend.presentation.dto.post.response.PostsReadResponseDto;
import com.example.postbackend.presentation.dto.post.response.error.PostNotFoundResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<PostNotFoundResponseDto> handlePostNotFoundException(
            PostNotFoundException ex
    ) {
        log.warn("post 저장소에 해당 게시글이 존재하지 않음, id: {}", ex.getId(), ex);

        PostNotFoundResponseDto postNotFoundResponseDto = new PostNotFoundResponseDto.Builder()
                .message(ex.getMessage())
                .errorCode(ex.getErrorCode())
                .id(ex.getId())
                .build();

        return new ResponseEntity<>(postNotFoundResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostPageOutOfRangeException.class)
    public ResponseEntity<PostsReadResponseDto> handlePageOutOfRangeException(
            PostPageOutOfRangeException ex
    ) {
        log.warn("범위를 초과한 양의 페이지, page: {}", ex.getPage(), ex);

        PostsReadResponseDto postsReadResponseDto = new PostsReadResponseDto.Builder()
                .message(ex.getMessage())
                .errorCode(ex.getErrorCode())
                .posts(Collections.emptyList())
                .page(ex.getPage())
                .build();

        return new ResponseEntity<>(postsReadResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PostNoContentException.class)
    public ResponseEntity<PostsReadResponseDto> handlePostNoContentException(
            PostNoContentException ex
    ) {
        log.info("post 저장소에 게시글이 하나도 없음, page: {}", ex.getPage(), ex);

        PostsReadResponseDto postsReadResponseDto = new PostsReadResponseDto.Builder()
                .message(ex.getMessage())
                .errorCode(ex.getErrorCode())
                .posts(Collections.emptyList())
                .page(ex.getPage())
                .build();

        return new ResponseEntity<>(postsReadResponseDto, HttpStatus.OK);
    }

    @ExceptionHandler(PostNegativePageException.class)
    public ResponseEntity<PostsReadResponseDto> handlerPostNegativePageException(
            PostNegativePageException ex
    ) {
        log.error("음의 페이지, page: {}", ex.getPage(), ex);

        PostsReadResponseDto postsReadResponseDto = new PostsReadResponseDto.Builder()
                .message(ex.getMessage())
                .errorCode(ex.getErrorCode())
                .posts(Collections.emptyList())
                .page(ex.getPage())
                .build();

        return new ResponseEntity<>(postsReadResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PostDeleteFailureInfrastructureException.class)
    public ResponseEntity<PostDeleteResponseDto> handlePostDeleteFailureInfrastructureException(
            PostDeleteFailureInfrastructureException ex
    ) {
        log.error("post 저장소에서 게시물 삭제 실패, id: {}", ex.getId(), ex.getCause());

        PostDeleteResponseDto postDeleteResponseDto = new PostDeleteResponseDto.Builder()
                .message(ex.getMessage())
                .errorCode(ex.getErrorCode())
                .build();

        return new ResponseEntity<>(postDeleteResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<PostErrorResponseDto> handleUnexpectedException(
            Exception ex
    ) {
        InternalServerException unexpectedException = new InternalServerException(ex.getCause());

        log.error("예기치 못한 에러", unexpectedException.getCause());

        PostErrorResponseDto postErrorResponseDto = new PostErrorResponseDto.Builder()
                .message(unexpectedException.getMessage())
                .errorCode(unexpectedException.getErrorCode())
                .build();

        return new ResponseEntity<>(postErrorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
