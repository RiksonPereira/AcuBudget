package com.riksonpereira.expensetracker.service;

import com.riksonpereira.expensetracker.dto.CategoryDto;
import com.riksonpereira.expensetracker.entity.Category;

import java.util.List;

public interface CategoryService{
    public CategoryDto createCategory(CategoryDto categoryDto);
    public CategoryDto getCategoryById(Long id);
    public List<CategoryDto> getAllCategories();
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto);
    public void deleteCategory(Long id);
}
