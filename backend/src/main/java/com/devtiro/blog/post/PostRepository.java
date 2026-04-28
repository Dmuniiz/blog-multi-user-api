package com.devtiro.blog.post;

import com.devtiro.blog.category.Category;
import com.devtiro.blog.users.User;
import com.devtiro.blog.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID>, JpaSpecificationExecutor {

   /* @EntityGraph(attributePaths = {"author", "category", "tags"})
    @Override
    Page<Post> findAll(Specification spec, Pageable pageable);*/

    List<Post> findAllByStatusAndCategoryAndTagsContaining(PostStatus postStatus, Category category, Tag tag);

    List<Post> findAllByStatusAndCategory(PostStatus postStatus, Category category);

    List<Post> findAllByStatusAndTagsContaining(PostStatus postStatus, Tag tag);

    List<Post> findAllByStatus(PostStatus postStatus);

    List<Post> findAllByAuthorAndStatus(User author, PostStatus status);
}
