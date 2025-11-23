package com.example.postbackend.application.post;

import com.example.postbackend.domain.post.Post;
import com.example.postbackend.domain.post.PostRepository;
import com.example.postbackend.presentation.dto.post.response.PostReadResponseDto;
import com.example.postbackend.presentation.dto.post.response.PostsReadResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimplePostService {
    private PostRepository postRepository;

    @Autowired
    SimplePostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostReadResponseDto findPost(Long id) {
        Post post = postRepository.findById(id);
        return PostReadResponseDto.toDto(post);
    }

    public PostsReadResponseDto findPosts(int page, int pageSize) {
        List<Post> posts = postRepository.findByPage(page, pageSize);
        PostsReadResponseDto postsReadResponseDto = new PostsReadResponseDto(posts, "정상 처리", page);
        return postsReadResponseDto;
    }

    public void deletePost(Long id) {
        this.postRepository.deleteById(id);
    }
}
