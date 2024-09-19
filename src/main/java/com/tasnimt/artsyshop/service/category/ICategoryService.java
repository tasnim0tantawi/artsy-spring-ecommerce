package com.tasnimt.artsyshop.service.category;

import com.tasnimt.artsyshop.model.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategory(Long id);
    List<Category> getCategoryByName(String name);
    List<Category> getAllCategories();
    Category addCategory(Category category);
    Category updateCategory(Category category, Long id);
    void deleteCategory(Long id);
}
