package com.riksonpereira.expensetracker.service.impl;

import com.riksonpereira.expensetracker.dto.CategoryDto;
import com.riksonpereira.expensetracker.entity.Category;
import com.riksonpereira.expensetracker.mapper.CategoryMapper;
import com.riksonpereira.expensetracker.repository.CategoryRepository;
import com.riksonpereira.expensetracker.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.mapToCategory(categoryDto);
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return  categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found"));

    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Long id, CategoryDto categoryDto) {
        Category category = getCategoryById(id);
        category.setName(categoryDto.name());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        getCategoryById(id);
        categoryRepository.deleteById(id);
    }
}
