package com.example.postbackend.presentation.dto.post.response;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class PostItemResponseDto {
    Long id;
    String title;
    String content;
}
