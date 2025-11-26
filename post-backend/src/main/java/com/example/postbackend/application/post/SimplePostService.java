package com.example.postbackend.application.post;

import com.example.postbackend.domain.post.Post;
import com.example.postbackend.domain.post.PostRepository;
import com.example.postbackend.presentation.dto.post.response.PostDeleteResponseDto;
import com.example.postbackend.presentation.dto.post.response.PostReadResponseDto;
import com.example.postbackend.presentation.dto.post.response.PostsReadResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimplePostService {
    private final PostRepository postRepository;
    private static final Logger log = LoggerFactory.getLogger(SimplePostService.class);

    @Autowired
    SimplePostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostReadResponseDto findPost(long id) {
        Post post = postRepository.findById(id);

        log.info("해당 게시글을 성공적으로 읽음, id: {}", id);

        PostReadResponseDto postReadResponseDto = PostReadResponseDto.from(post)
                .message("해당 게시글을 찾았습니다.")
                .build();

        return postReadResponseDto;
    }

    public PostsReadResponseDto findPosts(int page, int pageSize) {
        List<Post> posts = postRepository.findByPage(page, pageSize);

        log.info("해당 페이지를 성공적으로 불러옴, page: {}, pageSize: {}", page, pageSize);

        PostsReadResponseDto postsReadResponseDto = PostsReadResponseDto.from(posts)
                .message("페이지를 성공적으로 불러왔습니다.")
                .page(page)
                .build();

        return postsReadResponseDto;
    }

    public PostDeleteResponseDto deletePost(long id) {
        this.postRepository.deleteById(id);

        log.info("해당 게시글을 성공적으로 삭제, id: {}", id);

        PostDeleteResponseDto postDeleteResponseDto = new PostDeleteResponseDto.Builder()
                .message("게시글을 성공적으로 삭제했습니다.")
                .build();

        return postDeleteResponseDto;
    }
}
