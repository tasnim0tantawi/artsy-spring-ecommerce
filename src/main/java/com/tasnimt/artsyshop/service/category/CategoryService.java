package com.tasnimt.artsyshop.service.category;

import com.tasnimt.artsyshop.exception.ResourceNotFoundException;
import com.tasnimt.artsyshop.model.Category;
import com.tasnimt.artsyshop.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    CategoryRepo categoryRepo;
    @Override
    public Category getCategory(Long id) {
        return categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    @Override
    public Category getCategoryByName(String name) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    @Override
    public Category addCategory(Category category) {
        return null;
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {

    }
}
