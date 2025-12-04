package com.example.postbackend.presentation.dto.response.practice;

import com.example.postbackend.presentation.dto.response.BaseResponseDto;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class PracticeResponseDto extends BaseResponseDto {
    private final String practice;
}
