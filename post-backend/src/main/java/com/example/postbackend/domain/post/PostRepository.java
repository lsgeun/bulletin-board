package com.example.postbackend.domain.post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    long generateNextId();
    int getTotalPostCount();

    Optional<Post> findById(long id);
    List<Post> findByPage(int page, int pageSize);
    int deleteById(long id);
    Optional<Post> save(Post post);
}
