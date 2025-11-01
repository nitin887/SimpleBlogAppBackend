package com.simpleblogappbackend.simpleblogappbackend.service;

import com.simpleblogappbackend.simpleblogappbackend.dto.PostDto;
import com.simpleblogappbackend.simpleblogappbackend.entity.Post;
import com.simpleblogappbackend.simpleblogappbackend.exception.PostNotFoundException;
import com.simpleblogappbackend.simpleblogappbackend.mapper.PostMapper;
import com.simpleblogappbackend.simpleblogappbackend.repository.PostRepository;
import com.simpleblogappbackend.simpleblogappbackend.service.serviceinterface.PostServiceInterface;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService implements PostServiceInterface {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostService(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = postMapper.toEntity(postDto);
        post = postRepository.save(post);
        return postMapper.toDto(post);
    }

    @Override
    public PostDto updatePost(Long id, PostDto postDto) {
        Post postAlreadyExist = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("post not found with id" + postDto.getId()));
        postAlreadyExist.setTitle(postDto.getTitle());
        postAlreadyExist.setContent(postDto.getContent());
        postAlreadyExist.setAuthor(postDto.getAuthor());
        postRepository.save(postAlreadyExist);
        return postMapper.toDto(postAlreadyExist);
    }

    @Override
    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new PostNotFoundException("post not found with id" + id);
        } else {
            postRepository.deleteById(id);
        }
    }

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream().map(postMapper::toDto).toList();
    }

    @Override
    public List<PostDto> getPostById(Long id) {
        return postRepository.findById(id).stream().map(postMapper::toDto).toList();
    }

    @Override
    public List<PostDto> getPostByTitle(String title) {
        return postRepository.findByTitle(title).stream().map(postMapper::toDto).toList();
    }

    @Override
    public List<PostDto> getPostByContent(String content) {
        return postRepository.findByContent(content).stream().map(postMapper::toDto).toList();
    }

    @Override
    public List<PostDto> getPostByAuthor(String author) {
        return postRepository.findByAuthor(author).stream().map(postMapper::toDto).toList();
    }

    @Override
    public List<PostDto> getPostByContentCreatedAt(LocalDateTime contentCreatedAt) {
        return postRepository.findByContentCreatedAt(contentCreatedAt).stream().map(postMapper::toDto).toList();
    }
}
