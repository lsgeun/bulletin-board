package com.example.postbackend.domain.post;

import com.example.postbackend.presentation.dto.post.request.PostCreateRequestDto;
import com.example.postbackend.presentation.dto.post.request.PostUpdateRequestDto;
import com.example.postbackend.presentation.dto.post.response.PostItemResponseDto;
import com.example.postbackend.presentation.dto.post.response.PostReadResponseDto;
import com.example.postbackend.presentation.dto.post.response.PostsReadResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMappper {
    public PostItemResponseDto toPostItemResponseDto(Post post) {
        return PostItemResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    public List<PostItemResponseDto> toPostItemResponseDtos(List<Post> posts) {
        return posts.stream()
                .map(this::toPostItemResponseDto)
                .collect(Collectors.toList());
    }

    public PostReadResponseDto toPostReadResponseDto(Post post, String code, String message) {
        // ResponseDto 마다 다를 수 있는 정보를 받으면 될 듯.
        return PostReadResponseDto.builder()
                .code(code)
                .message(message)
                .post(this.toPostItemResponseDto(post))
                .build();
    }

    public PostsReadResponseDto toPostsReadResponseDto(List<Post> posts, Integer page, String code, String message) {
        return PostsReadResponseDto.builder()
                .code(code)
                .message(message)
                .posts(this.toPostItemResponseDtos(posts))
                .page(page)
                .build();
    }

    public Post toPost(PostCreateRequestDto postCreateRequestDto) {
        return Post.create(
                postCreateRequestDto.getPost().getTitle(),
                postCreateRequestDto.getPost().getContent()
        );
    }

    public Post toPost(PostUpdateRequestDto postUpdateRequestDto) {
        return Post.updateSpec(
                postUpdateRequestDto.getPost().getTitle(),
                postUpdateRequestDto.getPost().getContent()
        );
    }
}
