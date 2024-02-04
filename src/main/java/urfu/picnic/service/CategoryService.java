package urfu.picnic.service;

import urfu.picnic.entity.Category;

import java.util.List;

public interface CategoryService {
    List getAllCategories();

    void deleteCategory(Long categoryId);

    Category getCategoryById(Long categoryId);

    Category createCategory(Category category);

    Category updateCategory(Long categoryId, Category categoryDetails);
}
