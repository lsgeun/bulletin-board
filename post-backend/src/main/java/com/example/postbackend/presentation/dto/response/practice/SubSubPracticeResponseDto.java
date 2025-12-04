package com.example.postbackend.presentation.dto.response.practice;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class SubSubPracticeResponseDto extends SubPracticeResponseDto {
    private final String subSubPractice;
}
