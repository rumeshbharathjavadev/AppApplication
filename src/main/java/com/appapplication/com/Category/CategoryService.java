package com.appapplication.com.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategory();

    Optional<Category> getCategory(Long applicationId, Long userApplicationId, Long categoryId);

    boolean addCategory(Long applicationId, Long userApplicationId, Category category);

    boolean updateCategory(Long applicationId, Long userApplicationId, Long categoryId, Category category);

    boolean deleteCategory(Long applicationId, Long userApplicationId, Long categoryId);
}
