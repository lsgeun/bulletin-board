package com.example.postbackend.domain.post;

public class Post {
    private Long id;
    private String title;
    private String content;

    private Post(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

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
