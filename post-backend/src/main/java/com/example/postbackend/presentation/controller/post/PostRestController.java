package com.example.postbackend.presentation.controller.post;

import com.example.postbackend.application.post.SimplePostService;
import com.example.postbackend.presentation.dto.post.request.PostCreateRequestDto;
import com.example.postbackend.presentation.dto.post.request.PostUpdateRequestDto;
import com.example.postbackend.presentation.dto.post.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostRestController {
    private final SimplePostService simplePostService;

    @Autowired
    PostRestController(SimplePostService simplePostService) {
        this.simplePostService = simplePostService;
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<PostReadResponseDto> readPost(@PathVariable Long id) {
        PostReadResponseDto postReadResponseDto = this.simplePostService.readPost(id);
        return ResponseEntity.ok(postReadResponseDto);
    }

    @GetMapping("/post")
    public ResponseEntity<PostsReadResponseDto> readPosts(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize
    ) {
        PostsReadResponseDto postsReadResponseDto = this.simplePostService.readPosts(page, pageSize);
        return ResponseEntity.ok(postsReadResponseDto);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<PostDeleteResponseDto> deletePost(@PathVariable Long id) {
        PostDeleteResponseDto postDeleteResponseDto = this.simplePostService.deletePost(id);
        return ResponseEntity.ok(postDeleteResponseDto);
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<PostUpdateResponseDto> updatePost(
            @PathVariable Long id,
            @RequestBody PostUpdateRequestDto postUpdateRequestDto
    ) {
        PostUpdateResponseDto postUpdateResponseDto = this.simplePostService.updatePost(id, postUpdateRequestDto);
        return ResponseEntity.ok(postUpdateResponseDto);
    }

    @PostMapping("/post")
    public ResponseEntity<PostCreateResponseDto> createPost(
            @RequestBody PostCreateRequestDto postCreateRequestDto
            ) {
        PostCreateResponseDto postCreateResponseDto = this.simplePostService.createPost(postCreateRequestDto);
        return ResponseEntity.ok(postCreateResponseDto);
    }
}
