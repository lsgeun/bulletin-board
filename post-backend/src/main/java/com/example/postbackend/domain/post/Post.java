package com.example.postbackend.domain.post;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Post {
    private Long id;
    private String title;
    private String content;

    public boolean sameId(Long id) {
        return this.id.equals(id);
    }

    public static Post of(Long id, String title, String content) {
        return new Post(id, title, content);
    }

    public static Post create(String title, String content) {
        return new Post(null, title, content);
    }

    public static Post updateSpec(String title, String content) {
        return new Post(null, title, content);
    }

    public void updateTitleAndContent(Post post) {
        this.title = post.title;
        this.content = post.content;
    }

    public Post deepCopy() {
        return Post.of(this.id, this.title, this.content);
    }
}
