package com.example.postbackend.domain.post;

import java.util.List;

public interface PostRepository {
    public abstract Post findById(Long id);
    public abstract List<Post> findByPage(int page, int pageSize);
    public abstract void deleteById(Long id);
}
