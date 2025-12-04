package com.example.postbackend.presentation.dto.post.response;

import com.example.postbackend.domain.post.Post;
import com.example.postbackend.presentation.dto.response.BaseResponseDto;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
public class PostsReadResponseDto extends BaseResponseDto {
    private List<PostItemResponseDto> posts;
    private Integer page;
}
