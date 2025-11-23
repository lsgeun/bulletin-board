package com.example.postbackend.infrastructure.post;

import com.example.postbackend.domain.post.Post;
import com.example.postbackend.domain.post.PostRepository;
import com.example.postbackend.domain.post.exception.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class InMemoryPostRepository implements PostRepository {
    private final List<Post> posts = new ArrayList<>();
    private Long lastId;

    @PostConstruct
    public void initPosts() {
        for (long i = 1; i <= 49; i++) {
            posts.add(new Post(i, String.format("제목%d", i), String.format("내용%d", i)));
        }
    }

    @Override
    public Post findById(Long id) {
        return posts.stream()
                .filter(post -> post.sameId(id))
                .findFirst()
                .orElseThrow(() -> new PostNotFoundException(id));
    }

    @Override
    public List<Post> findByPage(int page, int pageSize) {
        int lastPage = (int) Math.ceil((double) posts.size() / pageSize);

        if (page < 1) {
            throw new PostNegativePageException(page);
        }
        if (lastPage == 0) {
            throw new PostNoContentException(page);
        }
        if (page > lastPage) {
            throw new PostPageOutOfRangeException(page);
        }

        int curPageFirstPostIndex = posts.size() - page * pageSize;
        int prevPageFirstPostIndex = posts.size() - (page - 1) * pageSize;
        List<Post> pageContent;
        if (1 <= page && page < lastPage) {
            pageContent = new ArrayList<>(posts.subList(curPageFirstPostIndex, prevPageFirstPostIndex));
        } else { // page == lastPage
            int lastPageSize = posts.size() % pageSize;
            if (lastPageSize == 0) {
                lastPageSize = pageSize;
            }

            pageContent = new ArrayList<>(posts.subList(prevPageFirstPostIndex - lastPageSize, prevPageFirstPostIndex));
        }

        Collections.reverse(pageContent);
        return pageContent;
    }

    @Override
    public void deleteById(Long id) {
        try {
            boolean removed = posts.removeIf(p -> p.sameId(id));
            if (!removed) {
                throw new PostNotFoundException(id);
            }
        } catch (Exception e) {
            throw new PostDeleteInfrastructureException(id, e);
        }
    }
}
