package com.appapplication.com.Category.impl;

import com.appapplication.com.Category.Category;
import com.appapplication.com.Category.CategoryRepository;
import com.appapplication.com.Category.CategoryService;
import com.appapplication.com.Type.Type;
import com.appapplication.com.UserApplication.UserApplication;
import com.appapplication.com.UserApplication.UserApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {


    private CategoryRepository categoryRepository;
    private UserApplicationService userApplicationService;


    public CategoryServiceImpl(CategoryRepository categoryRepository, UserApplicationService userApplicationService) {
        this.categoryRepository = categoryRepository;
        this.userApplicationService = userApplicationService;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategory(Long applicationId, Long userApplicationId, Long categoryId) {
        UserApplication userApplication=userApplicationService.getUserId(applicationId,userApplicationId);
        if (userApplication!=null) {
            return categoryRepository.findById(categoryId);
        }else  {
            return null;
        }

    }

    @Override
    public boolean addCategory(Long applicationId, Long userApplicationId, Category category) {
        UserApplication userApplication=userApplicationService.getUserId(applicationId,userApplicationId);
        if (userApplication!=null) {
            category.setUserApplication(userApplication);
            categoryRepository.save(category);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateCategory(Long applicationId, Long userApplicationId, Long categoryId, Category category) {
        UserApplication userApplication=userApplicationService.getUserId(applicationId,userApplicationId);
        if (userApplication!=null) {
            Optional<Category> updateCategory=categoryRepository.findById(categoryId);
            updateCategory.get().setCategory(category.getCategory());
            categoryRepository.save(updateCategory.get());
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteCategory(Long applicationId, Long userApplicationId, Long categoryId) {
        UserApplication userApplication=userApplicationService.getUserId(applicationId,userApplicationId);
        if (userApplication!=null) {
            categoryRepository.deleteById(categoryId);
            return true;
        }else  {
            return false;
        }
    }
}
