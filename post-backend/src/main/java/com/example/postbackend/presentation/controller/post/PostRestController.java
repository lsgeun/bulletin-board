package com.example.postbackend.presentation.controller.post;

import com.example.postbackend.application.post.SimplePostService;
import com.example.postbackend.presentation.dto.post.response.PostReadResponseDto;
import com.example.postbackend.presentation.dto.post.response.PostsReadResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostRestController {
    private SimplePostService simplePostService;

    @Autowired
    PostRestController(SimplePostService simplePostService) {
        this.simplePostService = simplePostService;
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
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

    @RequestMapping(value = "/post/{id}", method = RequestMethod.POST)
    public ResponseEntity<String> updatePostById(@PathVariable String id) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long id) {
        simplePostService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
