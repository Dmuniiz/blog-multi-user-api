package com.devtiro.blog.category;

import com.devtiro.blog.post.Post;
import com.devtiro.blog.post.PostStatus;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
        // Check if category with same name already exists (validation)
        if(categoryRepository.existsByNameIgnoreCase(category.getName())){
            throw new IllegalArgumentException("Category already exists with name: " + category.getName());
        }

        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategory(UUID id) {
        Category category = getCategoryById(id);
        if(!category.getPosts().isEmpty()){
            for (Post p : category.getPosts()) {
                if(p.getStatus() == PostStatus.DRAFT){
                    throw new IllegalStateException("Cannot delete category: " + category.getName() + ". It has associated posts DRAFT.");
                }
            }
            throw new IllegalStateException("Cannot delete category: " + category.getName() + ". It has associated posts.");
        }else{
            categoryRepository.delete(category);
        }
    }

    @Override
    public Category getCategoryById(UUID id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
    }
}
