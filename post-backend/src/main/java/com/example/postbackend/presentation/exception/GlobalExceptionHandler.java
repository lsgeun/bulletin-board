package com.example.postbackend.presentation.exception;

import com.example.postbackend.domain.post.exception.*;
import com.example.postbackend.presentation.dto.ErrorMessageDto;
import com.example.postbackend.presentation.dto.post.response.PostsReadResponseDto;
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
    public ResponseEntity<ErrorMessageDto> handleEntityNotFoundException(
            PostNotFoundException ex
    ) {
        log.warn("게시글이 존재하지 않음, id: {}", ex.getId(), ex);
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(ex.getMessage());
        return new ResponseEntity<>(errorMessageDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostPageOutOfRangeException.class)
    public ResponseEntity<PostsReadResponseDto> handlePageOutOfRangeException(
            PostPageOutOfRangeException ex
    ) {
        log.warn("페이지 범위를 초과, page: {}", ex.getPage(), ex);
        PostsReadResponseDto postsReadResponseDto = new PostsReadResponseDto(Collections.emptyList(), ex.getMessage(), ex.getPage());
        return new ResponseEntity<>(postsReadResponseDto, HttpStatus.OK);
    }

    @ExceptionHandler(PostNoContentException.class)
    public ResponseEntity<PostsReadResponseDto> handleNoContentException(
            PostNoContentException ex
    ) {
        log.info("게시글이 하나도 없음, page: {}", ex.getPage(), ex);
        PostsReadResponseDto postsReadResponseDto = new PostsReadResponseDto(Collections.emptyList(), ex.getMessage(), ex.getPage());
        return new ResponseEntity<>(postsReadResponseDto, HttpStatus.OK);
    }

    @ExceptionHandler(PostNegativePageException.class)
    public ResponseEntity<PostsReadResponseDto> handlerNegativePageException(
            PostNegativePageException ex
    ) {
        log.error("음의 페이지, page: {}", ex.getPage(), ex);
        PostsReadResponseDto postsReadResponseDto = new PostsReadResponseDto(Collections.emptyList(), ex.getMessage(), ex.getPage());
        return new ResponseEntity<>(postsReadResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PostDeleteInfrastructureException.class)
    public ResponseEntity<ErrorMessageDto> handleDeleteException(
            PostDeleteInfrastructureException ex
    ) {
        log.error("게시물 삭제 실패, id: {}", ex.getId(), ex.getCause());
        return new ResponseEntity<>(new ErrorMessageDto(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessageDto> handleUnexpectedException(
            Exception ex
    ) {
        log.error("예기치 못한 에러", ex);
        return new ResponseEntity<>(new ErrorMessageDto("서버 내부 에러"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
