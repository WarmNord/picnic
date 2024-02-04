package urfu.picnic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urfu.picnic.entity.Category;
import urfu.picnic.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;


    @Autowired
    public void CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteByCategoryId(Math.toIntExact(categoryId));
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findByCategoryId(categoryId);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long categoryId, Category categoryDetails) {
        Category existingCategory = categoryRepository.findById(Math.toIntExact(categoryId))
                .orElseThrow(() -> new RuntimeException("Category not found"));

        existingCategory.setCategoryName(categoryDetails.getCategoryName());

        Category updatedCategory = categoryRepository.save(existingCategory);
        return updatedCategory;
    }
}
