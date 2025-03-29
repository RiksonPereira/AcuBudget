package com.riksonpereira.expensetracker.controller;

import com.riksonpereira.expensetracker.dto.CategoryDto;
import com.riksonpereira.expensetracker.entity.Category;
import com.riksonpereira.expensetracker.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    CategoryService categoryService;

    @PostMapping("/createCategory")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto category = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/getCategory/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long id) {
        CategoryDto category = categoryService.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/getCategory")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PutMapping("updateCategory/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDto categoryDto) {
        CategoryDto category = categoryService.updateCategory(id, categoryDto);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Deleted Successfully!");
    }
}
