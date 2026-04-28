package com.devtiro.blog.post;

import com.devtiro.blog.post.dtos.CreatePostRequest;
import com.devtiro.blog.post.dtos.UpdatePostRequest;
import com.devtiro.blog.post.dtos.CreatePostRequestDto;
import com.devtiro.blog.post.dtos.PostResponse;
import com.devtiro.blog.post.dtos.UpdatePostRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    PostResponse toDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDto dto);

    UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto dto);

}
