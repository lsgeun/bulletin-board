package com.example.postbackend.presentation.controller.practice;

import com.example.postbackend.presentation.dto.post.response.PostItemResponseDto;
import com.example.postbackend.presentation.dto.response.practice.PracticeResponseDto;
import com.example.postbackend.presentation.dto.response.practice.SubPracticeResponseDto;
import com.example.postbackend.presentation.dto.response.practice.SubSubPracticeResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PracticeController {

    @GetMapping("/practice")
    public ResponseEntity<PracticeResponseDto> practice() {
        PracticeResponseDto practiceResponseDto = PracticeResponseDto.builder()
                .practice("practice")
                // .subPractice("sub-practice")
                // .subSubPractice("sub-sub-practice")
                .build();

        return new ResponseEntity<>(practiceResponseDto, HttpStatus.OK);
    }

    @GetMapping("/sub-practice")
    public ResponseEntity<SubPracticeResponseDto> subPractice() {
        SubPracticeResponseDto postSubPracticeResponseDto = SubPracticeResponseDto.builder()
                .practice("practice")
                .subPractice("sub-practice")
                // .subSubPractice("sub-sub-practice")
                .build();

        return new ResponseEntity<>(postSubPracticeResponseDto, HttpStatus.OK);
    }

    @GetMapping("/sub-sub-practice")
    public ResponseEntity<SubSubPracticeResponseDto> subSubPractice() {
        SubSubPracticeResponseDto postSubSubPracticeResponseDto = SubSubPracticeResponseDto.builder()
                .practice("practice")
                .subPractice("sub-practice")
                .subSubPractice("sub-sub-practice")
                .build();

        return new ResponseEntity<>(postSubSubPracticeResponseDto, HttpStatus.OK);
    }

    @GetMapping("/post-response-dto")
    public ResponseEntity<PostItemResponseDto> postResponseDto() {
        PostItemResponseDto postResponseDto = PostItemResponseDto.builder()
                .id(1L)
                .title("title")
                .content("content")
                .build();

        return new ResponseEntity<>(postResponseDto, HttpStatus.OK);
    }
}
