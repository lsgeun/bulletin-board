package com.example.postbackend.domain.post;

import com.example.postbackend.presentation.dto.post.request.PostCreateRequestDto;
import com.example.postbackend.presentation.dto.post.request.PostUpdateRequestDto;
import com.example.postbackend.presentation.dto.post.response.PostItemResponseDto;
import com.example.postbackend.presentation.dto.post.response.PostReadResponseDto;
import com.example.postbackend.presentation.dto.post.response.PostsReadResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostItemResponseDto toPostItemResponseDto(Post post);
    List<PostItemResponseDto> toPostItemResponseDtos(List<Post> posts);
    PostReadResponseDto toPostReadResponseDto(Post post, String code, String message);
    PostsReadResponseDto toPostsReadResponseDto(List<Post> posts, Integer page, String code, String message);

    default Post toPost(PostCreateRequestDto postCreateRequestDto) {
        return Post.create(
                postCreateRequestDto.getPost().getTitle(),
                postCreateRequestDto.getPost().getContent()
        );
    }

    default Post toPost(PostUpdateRequestDto postUpdateRequestDto) {
        return Post.updateSpec(
                postUpdateRequestDto.getPost().getTitle(),
                postUpdateRequestDto.getPost().getContent()
        );
    }
}