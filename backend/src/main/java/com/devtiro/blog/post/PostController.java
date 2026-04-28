package com.devtiro.blog.post;

import com.devtiro.blog.post.dtos.CreatePostRequest;
import com.devtiro.blog.post.dtos.UpdatePostRequest;
import com.devtiro.blog.users.User;
import com.devtiro.blog.post.dtos.CreatePostRequestDto;
import com.devtiro.blog.post.dtos.PostResponse;
import com.devtiro.blog.post.dtos.UpdatePostRequestDto;
import com.devtiro.blog.users.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostMapper postMapper;
    private final UserService userService;

    /*@GetMapping
    public ResponseEntity<Page<PostDto>> getPosts(
            @RequestParam(required = false) UUID categoryId,
            @RequestParam(required = false) UUID tagId,
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {

        return ResponseEntity.ok(postService.getAllPosts(categoryId, tagId, pageable).map(postMapper::toDto));
    }*/

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts(@RequestParam(required = false) UUID categoryId, @RequestParam(required = false) UUID tagId) {

        List<Post> posts = postService.getAllPosts(categoryId, tagId);

        List<PostResponse> postResponses = posts.stream().map(postMapper::toDto).toList();

        return ResponseEntity.ok(postResponses);
    }

    @GetMapping("/drafts")
    public ResponseEntity<List<PostResponse>> getDrafts(@RequestAttribute UUID userId){
        User loggedIdUser = userService.getUserById(userId);
        List<Post> draftPosts = postService.getDraftPosts(loggedIdUser);

        List<PostResponse> postResponses = draftPosts.stream().map(postMapper::toDto).toList();

        return ResponseEntity.ok(postResponses);
    }

    @PostMapping
    public ResponseEntity<PostResponse> createPost(@Valid @RequestBody CreatePostRequestDto createPostRequestDto, @RequestAttribute UUID userId ){
        User loggedInUser = userService.getUserById(userId);
        CreatePostRequest createPost = postMapper.toCreatePostRequest(createPostRequestDto);
        Post createdPost = postService.createPost(loggedInUser, createPost);
        PostResponse createdPostResponse = postMapper.toDto(createdPost);

        return new ResponseEntity<>(createdPostResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> updatePost(@PathVariable UUID id, @Valid @RequestBody UpdatePostRequestDto updatePostRequestDto){
        UpdatePostRequest updatePostRequest = postMapper.toUpdatePostRequest(updatePostRequestDto);
        Post updatedPost = postService.updatePost(id, updatePostRequest);
        PostResponse updatePostResponse = postMapper.toDto(updatedPost);

        return ResponseEntity.ok(updatePostResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable UUID id) {
        Post post = postService.getPost(id);
        PostResponse postResponse = postMapper.toDto(post);
        return ResponseEntity.ok(postResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable UUID id){
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
