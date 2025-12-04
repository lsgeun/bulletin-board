package com.example.postbackend.presentation.dto.response.practice;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class SubPracticeResponseDto extends PracticeResponseDto {
    private final String subPractice;
}
