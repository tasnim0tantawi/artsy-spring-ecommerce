package com.tasnimt.artsyshop.service.category;

import com.tasnimt.artsyshop.exception.AlreadyExistsException;
import com.tasnimt.artsyshop.exception.ResourceNotFoundException;
import com.tasnimt.artsyshop.model.Category;
import com.tasnimt.artsyshop.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
        return categoryRepo.findByName(name);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category addCategory(Category category) {
//        return  Optional.of(category).filter(c -> !categoryRepo.existsByName(c.getName()))
//                .map(categoryRepo :: save)
//                .orElseThrow(() -> new AlreadyExistsException(category.getName()+" already exists"));
        // check if category already exists using name

       Category existingCategory = categoryRepo.findByName(category.getName());
         if (existingCategory != null) {
              throw new AlreadyExistsException("Category already exists");
            }

        return categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        Optional<Category> categoryOptional = categoryRepo.findById(id);
        if (categoryOptional.isEmpty()) {
            throw new ResourceNotFoundException("Category not found");
        }
        Category existingCategory = categoryOptional.get();
        existingCategory.setName(category.getName());
        return categoryRepo.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepo.findById(id).ifPresentOrElse(categoryRepo::delete, () -> {
            throw new ResourceNotFoundException("Category not found");
        });
    }
}
