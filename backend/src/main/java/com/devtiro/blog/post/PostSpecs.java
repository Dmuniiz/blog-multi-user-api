package com.devtiro.blog.post;

import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class PostSpecs {

    public static Specification<Post> hasStatus(PostStatus status) {
        return (root, query, cb) -> cb.equal(root.get("status"), status);
    }

    public static Specification<Post> hasCategory(UUID categoryId) {
        return (root, query, cb) -> cb.equal(root.get("category").get("id"), categoryId);
    }

    public static Specification<Post> hasTag(UUID tagId) {
        return (root, query, cb) -> cb.equal(root.join("tags").get("id"), tagId);
    }

}
