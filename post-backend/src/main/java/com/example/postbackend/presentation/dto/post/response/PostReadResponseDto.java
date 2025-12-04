package com.example.postbackend.presentation.dto.post.response;

import com.example.postbackend.presentation.dto.response.BaseResponseDto;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class PostReadResponseDto extends BaseResponseDto {
    private PostItemResponseDto post;
}
