package com.devtiro.blog.post.dtos;

import com.devtiro.blog.category.dtos.CategoryDto;
import com.devtiro.blog.tags.dtos.TagDto;
import com.devtiro.blog.post.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {

    private UUID id;
    private String title;
    private String content;
    //TODO: Author
    private AuthorDto author;
    private Set<TagDto> tags;
    private CategoryDto category;
    private Integer readingTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private PostStatus postStatus;

}
