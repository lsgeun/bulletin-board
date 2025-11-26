package com.example.postbackend.presentation.controller.post;

import com.example.postbackend.application.post.SimplePostService;
import com.example.postbackend.presentation.dto.post.response.PostDeleteResponseDto;
import com.example.postbackend.presentation.dto.post.response.PostReadResponseDto;
import com.example.postbackend.presentation.dto.post.response.PostUpdateResponseDto;
import com.example.postbackend.presentation.dto.post.response.PostsReadResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<PostReadResponseDto> getPostById(@PathVariable String id) {
        PostReadResponseDto postReadResponseDto = simplePostService.findPost(Long.valueOf(id));
        return ResponseEntity.ok(postReadResponseDto);
    }

    @GetMapping("/post")
    public ResponseEntity<PostsReadResponseDto> getPostsByPage(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize
    ) {
        PostsReadResponseDto postsReadResponseDto = simplePostService.findPosts(page, pageSize);
        return ResponseEntity.ok(postsReadResponseDto);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<PostDeleteResponseDto> deletePostById(@PathVariable Long id) {
        PostDeleteResponseDto postDeleteResponseDto = simplePostService.deletePost(id);
        return new ResponseEntity<>(postDeleteResponseDto, HttpStatus.OK);
    }

    @PostMapping("/post/{id}")
    public ResponseEntity<String> createPostById(@PathVariable String id) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<PostUpdateResponseDto> updatePostById(@PathVariable String id) {
        return ResponseEntity.ok(null);
    }
}
