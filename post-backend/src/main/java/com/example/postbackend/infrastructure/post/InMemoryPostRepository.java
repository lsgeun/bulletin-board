package com.example.postbackend.infrastructure.post;

import com.example.postbackend.domain.post.Post;
import com.example.postbackend.domain.post.PostRepository;
import com.example.postbackend.domain.post.exception.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryPostRepository implements PostRepository {
    private final List<Post> posts = new ArrayList<>();
    private Integer totalPostCount = 49;
    private Long idSequence = 49L;

    public long generateNextId() {
        this.idSequence++;
        return this.idSequence;
    }

    public int getTotalPostCount() {
        return this.totalPostCount;
    }

    @PostConstruct
    public void initPosts() {
        for (long i = 1; i <= 49; i++) {
            this.posts.add(Post.of(i, String.format("제목%d", i), String.format("내용%d", i)));
        }
    }

    private Optional<Post> findPostInCollection(long id) {
        return this.posts.stream()
                .filter(post -> post.sameId(id))
                .findFirst();
    }

    @Override
    public Optional<Post> findById(long id) {
        return this.findPostInCollection(id)
                .map(Post::deepCopy);
    }

    @Override
    public List<Post> findByPage(int page, int pageSize) {
        int curPageFirstPostIndex = this.posts.size() - page * pageSize;
        int prevPageFirstPostIndex = this.posts.size() - (page - 1) * pageSize;
        List<Post> pageContent;
        int lastPage = (int) Math.ceil((double) this.posts.size() / pageSize);

        if (1 <= page && page < lastPage) {
            pageContent = this.posts.subList(curPageFirstPostIndex, prevPageFirstPostIndex)
                    .stream()
                    .map(Post::deepCopy)
                    .collect(Collectors.toList());
        } else { // page == lastPage
            int lastPageSize = this.posts.size() % pageSize;
            if (lastPageSize == 0) {
                lastPageSize = pageSize;
            }

            pageContent = this.posts.subList(prevPageFirstPostIndex - lastPageSize, prevPageFirstPostIndex)
                    .stream()
                    .map(Post::deepCopy)
                    .collect(Collectors.toList());
        }

        Collections.reverse(pageContent);

        return pageContent;
    }

    @Override
    public int deleteById(long id) {
        try {
            boolean deleted = this.posts.removeIf(p -> p.sameId(id));
            if (deleted) {
                totalPostCount--;
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            throw new PostDeleteFailureInfrastructureException(id, e);
        }
    }

    @Override
    public Optional<Post> save(Post post) {
        // create, update 로직 만들기
        if (post.getId() == null) {
            long createId = this.generateNextId();
            Post postToCreate = Post.of(createId, post.getTitle(), post.getContent());

            this.posts.add(postToCreate);

            Optional<Post> createdPostOptional = this.findPostInCollection(createId);

            if (createdPostOptional.isEmpty()) {
                return createdPostOptional;
            }

            totalPostCount++;

            return Optional.of(createdPostOptional.get().deepCopy());
        } else {
            Optional<Post> postToUpdateOptional = this.findPostInCollection(post.getId());

            if (postToUpdateOptional.isEmpty()) {
                return postToUpdateOptional;
            }

            postToUpdateOptional.get().updateTitleAndContent(post);

            Optional<Post> updatedPostOptional = postToUpdateOptional;

            return Optional.of(updatedPostOptional.get().deepCopy()); // 수정
        }
    }
}
