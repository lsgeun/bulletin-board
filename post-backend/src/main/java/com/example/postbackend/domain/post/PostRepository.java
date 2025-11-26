package com.example.postbackend.domain.post;

import java.util.List;

public interface PostRepository {
    public abstract Post findById(long id);
    public abstract List<Post> findByPage(int page, int pageSize);
    public abstract void deleteById(long id);
}
