package com.simpleblogappbackend.simpleblogappbackend.controller;

import com.simpleblogappbackend.simpleblogappbackend.dto.PostDto;
import com.simpleblogappbackend.simpleblogappbackend.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@Tag(name = "Post Controller", description = "Endpoints for managing posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Operation(summary = "Create a new post")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Post created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto createPost(@RequestBody PostDto postDto) {
        return postService.createPost(postDto);
    }

    @Operation(summary = "Update an existing post")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Post updated successfully"),
            @ApiResponse(responseCode = "404", description = "Post not found")
    })
    @PutMapping("/{id}")
    public PostDto updatePost(@Parameter(description = "ID of the post to update") @PathVariable Long id, @RequestBody PostDto postDto) {
        return postService.updatePost(id, postDto);
    }

    @Operation(summary = "Delete a post by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Post deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Post not found")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@Parameter(description = "ID of the post to delete") @PathVariable Long id) {
        postService.deletePost(id);
    }

    @Operation(summary = "Get all posts")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of posts")
    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @Operation(summary = "Get a post by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved post"),
            @ApiResponse(responseCode = "404", description = "Post not found")
    })
    @GetMapping("/{id}")
    public List<PostDto> getPostById(@Parameter(description = "ID of the post to retrieve") @PathVariable Long id) {
        return postService.getPostById(id);
    }

    @Operation(summary = "Search posts by title")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved posts")
    @GetMapping(params = "title")
    public List<PostDto> getPostByTitle(@Parameter(description = "Title to search for") @RequestParam String title) {
        return postService.getPostByTitle(title);
    }

    @Operation(summary = "Search posts by content")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved posts")
    @GetMapping(params = "content")
    public List<PostDto> getPostByContent(@Parameter(description = "Content to search for") @RequestParam String content) {
        return postService.getPostByContent(content);
    }

    @Operation(summary = "Search posts by author")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved posts")
    @GetMapping(params = "author")
    public List<PostDto> getPostByAuthor(@Parameter(description = "Author to search for") @RequestParam String author) {
        return postService.getPostByAuthor(author);
    }

    @Operation(summary = "Search posts by creation date")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved posts")
    @GetMapping(params = "createdAt")
    public List<PostDto> getPostByContentCreatedAt(@Parameter(description = "Creation date to search for (ISO 8601 format)") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime createdAt) {
        return postService.getPostByContentCreatedAt(createdAt);
    }
}
