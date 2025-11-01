package com.simpleblogappbackend.simpleblogappbackend.mapper;

import com.simpleblogappbackend.simpleblogappbackend.dto.PostDto;
import com.simpleblogappbackend.simpleblogappbackend.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "content", source = "content")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "contentCreatedAt", source = "contentCreatedAt")
    Post toEntity(PostDto postDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "content", source = "content")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "contentCreatedAt", source = "contentCreatedAt")
    PostDto toDto(Post post);
}
