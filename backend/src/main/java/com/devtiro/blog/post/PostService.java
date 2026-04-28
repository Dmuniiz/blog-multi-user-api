package com.devtiro.blog.post;

import com.devtiro.blog.post.dtos.CreatePostRequest;
import com.devtiro.blog.post.dtos.UpdatePostRequest;
import com.devtiro.blog.users.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllPosts(UUID categoryId, UUID tagId);

    /*Page<Post> getAllPosts(UUID categoryId, UUID tagId, Pageable pageable);*/

    List<Post> getDraftPosts(User user);

    Post createPost(User user, CreatePostRequest createPostRequest);

    Post updatePost(UUID postId, UpdatePostRequest updatePostRequest);

    Post getPost(UUID postId);

    void deletePost(UUID id);

}
