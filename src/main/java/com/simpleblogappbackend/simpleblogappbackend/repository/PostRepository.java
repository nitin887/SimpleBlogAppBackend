package com.simpleblogappbackend.simpleblogappbackend.repository;

import com.simpleblogappbackend.simpleblogappbackend.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
   List<Post> findByTitle(String title);
   Optional<Post> findById(Long id);
   List<Post> findByContent(String content);
   List<Post> findByAuthor(String author);
   List<Post> findByContentCreatedAt(LocalDateTime contentCreatedAt);

}
