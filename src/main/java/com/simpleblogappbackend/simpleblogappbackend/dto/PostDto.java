package com.simpleblogappbackend.simpleblogappbackend.dto;

public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String contentCreatedAt;

    public PostDto() {
    }

    public PostDto(Long id, String title, String content, String author, String contentCreatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.contentCreatedAt = contentCreatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContentCreatedAt() {
        return contentCreatedAt;
    }

    public void setContentCreatedAt(String contentCreatedAt) {
        this.contentCreatedAt = contentCreatedAt;
    }
}
