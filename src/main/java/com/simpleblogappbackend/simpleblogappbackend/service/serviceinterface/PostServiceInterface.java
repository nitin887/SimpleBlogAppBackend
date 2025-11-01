package com.simpleblogappbackend.simpleblogappbackend.service.serviceinterface;

import com.simpleblogappbackend.simpleblogappbackend.dto.PostDto;

import java.time.LocalDateTime;
import java.util.List;

public interface PostServiceInterface {
    //create post
    PostDto createPost(PostDto postDto);
    //update post
    PostDto updatePost(Long id, PostDto postDto);
    //delete post
    void deletePost(Long id);
    //get all posts
    List<PostDto> getAllPosts();
    //get post by id
    List<PostDto> getPostById(Long id);
    //get post by title
    List<PostDto> getPostByTitle(String title);
    //get post by content
    List<PostDto> getPostByContent(String content);
    //get post by author
    List<PostDto> getPostByAuthor(String author);
    //get post by content created at
    List<PostDto> getPostByContentCreatedAt(LocalDateTime contentCreatedAt);

}
