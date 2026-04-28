package com.devtiro.blog.tags;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface TagService {

    List<Tag> getAllTags();

    List<Tag> createTags(Set<String> tagNames);

    void deleteTag(UUID id);

    Tag getTagById(UUID id);

    List<Tag> getTagByIds(Set<UUID> ids);

}
