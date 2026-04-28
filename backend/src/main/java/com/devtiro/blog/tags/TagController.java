package com.devtiro.blog.tags;

import com.devtiro.blog.tags.dtos.CreateTagRequest;
import com.devtiro.blog.tags.dtos.TagDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/tags")
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;

    @GetMapping
    public ResponseEntity<List<TagDto>> getAllTags(){
        List<Tag> tags = tagService.getAllTags();
        List<TagDto> tagDto = tags.stream().map(tag -> tagMapper.toTagResponse(tag)).toList();
        return ResponseEntity.ok(tagDto);
    }

    @PostMapping
    public ResponseEntity<List<TagDto>> createTags(@RequestBody CreateTagRequest createTagRequest){
        List<Tag> savedTags = tagService.createTags(createTagRequest.getNames());
        List<TagDto> createTagRespons = savedTags.stream().map(tagMapper::toTagResponse).toList();

        return new ResponseEntity<>(createTagRespons, HttpStatus.CREATED);

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable UUID id){
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }

}
