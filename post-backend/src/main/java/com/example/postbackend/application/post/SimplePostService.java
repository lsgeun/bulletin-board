package com.example.postbackend.application.post;

import com.example.postbackend.domain.post.Post;
import com.example.postbackend.domain.post.PostMapper;
import com.example.postbackend.domain.post.PostRepository;
import com.example.postbackend.domain.post.exception.PostNegativePageException;
import com.example.postbackend.domain.post.exception.PostNoContentException;
import com.example.postbackend.domain.post.exception.PostNotFoundException;
import com.example.postbackend.domain.post.exception.PostPageOutOfRangeException;
import com.example.postbackend.presentation.dto.post.request.PostCreateRequestDto;
import com.example.postbackend.presentation.dto.post.request.PostUpdateRequestDto;
import com.example.postbackend.presentation.dto.post.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimplePostService {
    private final PostRepository postRepository;
    private final Logger log = LoggerFactory.getLogger(SimplePostService.class);
    private final PostMapper postMapper;

    @Autowired
    SimplePostService(
            PostRepository postRepository,
            PostMapper postMapper
    ) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    private Post readPostEntity(long id) {
        Post post = this.postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));

        return post;
    }

    private List<Post> readPostsEntity(int page, int pageSize) {
        int totalPostCount = this.postRepository.getTotalPostCount();
        int lastPage = (int) Math.ceil((double) totalPostCount / pageSize);

        if (page < 1) {
            throw new PostNegativePageException(page);
        }
        if (lastPage == 0) {
            throw new PostNoContentException(page);
        }
        if (page > lastPage) {
            throw new PostPageOutOfRangeException(page);
        }

        List<Post> posts = this.postRepository.findByPage(page, pageSize);

        return posts;
    }

    private Post deletePostEntity(long id) {
        Post postToDelete = this.readPostEntity(id);

        int deletedCount = this.postRepository.deleteById(id);
        if (deletedCount == 0) {
            throw new PostNotFoundException(id);
        }

        return postToDelete;
    }

    private Post updatePostCore(long id, PostUpdateRequestDto postUpdateRequestDto) {
        Post postToUpdate = this.readPostEntity(id);
        Post postUpdateSpec = this.postMapper.toPost(postUpdateRequestDto);
        postToUpdate.updateTitleAndContent(postUpdateSpec);

        Post updatedPost = this.postRepository.save(postToUpdate)
                .orElseThrow(() -> new PostNotFoundException(id));

        return updatedPost;
    }

    private Post createPostEntity(PostCreateRequestDto postCreateRequestDto) {
        Post postToCreate =  this.postMapper.toPost(postCreateRequestDto);

        Post createdPost = this.postRepository.save(postToCreate)
                .orElseThrow(() -> new PostNotFoundException(0L));

        return createdPost;
    }

    public PostReadResponseDto readPost(long id) {
        Post post = this.readPostEntity(id);

        log.info("해당 게시글을 성공적으로 읽음, id: {}", post.getId());

        PostReadResponseDto postReadResponseDto = this.postMapper.toPostReadResponseDto(post, "POST_RETRIEVED", "해당 게시글을 찾았습니다.");

        return postReadResponseDto;
    }

    public PostsReadResponseDto readPosts(int page, int pageSize) {
        List<Post> posts = this.readPostsEntity(page, pageSize);

        log.info("해당 페이지를 성공적으로 불러옴, page: {}, pageSize: {}", page, pageSize);

        PostsReadResponseDto postsReadResponseDto = this.postMapper.toPostsReadResponseDto(posts, page, "POSTS_RETRIEVED", "페이지를 성공적으로 불러왔습니다.");

        return postsReadResponseDto;
    }

    public PostDeleteResponseDto deletePost(long id) {
        Post deletedPost = this.deletePostEntity(id);

        log.info("해당 게시글을 성공적으로 삭제, id: {}", deletedPost.getId());

        PostDeleteResponseDto postDeleteResponseDto = PostDeleteResponseDto.builder()
                .code("POST_DELETED")
                .message("게시글을 성공적으로 삭제했습니다")
                .build();

        return postDeleteResponseDto;
    }

    public PostUpdateResponseDto updatePost(long id, PostUpdateRequestDto postUpdateRequestDto) {
        Post updatedPost = this.updatePostCore(id, postUpdateRequestDto);

        log.info("해당 게시글을 성공적으로 수정, id: {}", updatedPost.getId());

        PostUpdateResponseDto postUpdateResponseDto = PostUpdateResponseDto.builder()
                .code("POST_UPDATED")
                .message("게시글을 성공적으로 수정했습니다.")
                .build();

        return postUpdateResponseDto;
    }

    public PostCreateResponseDto createPost(PostCreateRequestDto postCreateRequestDto) {
        Post createdPost = this.createPostEntity(postCreateRequestDto);

        log.info("해당 게시글을 성공적으로 생성, id: {}", createdPost.getId());

        PostCreateResponseDto postCreateResponseDto = PostCreateResponseDto.builder()
                .code("POST_CREATED")
                .message("게시글을 성공적으로 생성했습니다.")
                .build();

        return postCreateResponseDto;
    }
}
