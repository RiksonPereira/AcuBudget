package com.riksonpereira.expensetracker.service;

import com.riksonpereira.expensetracker.dto.CategoryDto;
import com.riksonpereira.expensetracker.entity.Category;

import java.util.List;

public interface CategoryService{
    public Category createCategory(CategoryDto categoryDto);
    public Category getCategoryById(Long id);
    public List<Category> getAllCategories();
    public Category updateCategory(Long id, CategoryDto categoryDto);
    public void deleteCategory(Long id);
}
