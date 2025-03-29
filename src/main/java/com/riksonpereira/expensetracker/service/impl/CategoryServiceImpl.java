package com.riksonpereira.expensetracker.service.impl;

import com.riksonpereira.expensetracker.dto.CategoryDto;
import com.riksonpereira.expensetracker.entity.Category;
import com.riksonpereira.expensetracker.mapper.CategoryMapper;
import com.riksonpereira.expensetracker.repository.CategoryRepository;
import com.riksonpereira.expensetracker.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.mapToCategory(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found"));
        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> category = categoryRepository.findAll();
        return category.stream().map(CategoryMapper::mapToCategoryDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
        category.setName(categoryDto.name());
        Category updatedCategory = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        getCategoryById(id);
        categoryRepository.deleteById(id);
    }
}
