package com.example.postbackend.presentation.dto.post.response.error;

import com.example.postbackend.presentation.dto.response.BaseResponseDto;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class PostNotFoundResponseDto extends BaseResponseDto {
    private Long id;
}
