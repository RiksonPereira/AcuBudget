package com.riksonpereira.expensetracker.service.impl;

import com.riksonpereira.expensetracker.dto.ExpenseDto;
import com.riksonpereira.expensetracker.entity.Category;
import com.riksonpereira.expensetracker.entity.Expense;
import com.riksonpereira.expensetracker.exceptions.CategoryNotFoundException;
import com.riksonpereira.expensetracker.exceptions.ExpenseNotFoundException;
import com.riksonpereira.expensetracker.mapper.ExpenseMapper;
import com.riksonpereira.expensetracker.repository.CategoryRepository;
import com.riksonpereira.expensetracker.repository.ExpenseRepository;
import com.riksonpereira.expensetracker.service.CategoryService;
import com.riksonpereira.expensetracker.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    ExpenseRepository expenseRepository;
    CategoryRepository categoryRepository;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = ExpenseMapper.mapToExpense(expenseDto);
        Expense savedExpense = expenseRepository.save(expense);
        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    // add a default date if not provided
    @Override
    public ExpenseDto getExpenseById(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException("Expense not found"));
        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getExpensesByCategory(String category) {
        List<Expense> expense = expenseRepository.findByCategory_Name(category);
        return expense.stream().map(ExpenseMapper::mapToExpenseDto).collect(Collectors.toList());
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream()
                .map(ExpenseMapper::mapToExpenseDto)
                .collect(Collectors.toList());

    }

    @Override
    public Double getTotalExpenses() {
        Double totalExpense = 0.0;
        List<Expense> expenses = expenseRepository.findAll();
        for (Expense expense : expenses) {
            totalExpense += expense.getAmount();
        }
        return totalExpense;
    }

    //need to update the method to take only the values passed
    @Override
    public ExpenseDto updateExpense(Long id, ExpenseDto expenseDto) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException("Expense not found"));
        expense.setExpenseDate(expenseDto.expenseDate());
        expense.setAmount(expenseDto.amount());
        expense.setDescription(expenseDto.description());
        if(expenseDto.categoryDto() != null) {
            Category category = categoryRepository.findById(expenseDto.categoryDto().id()).orElseThrow(()-> new RuntimeException("Category not found"));
            expense.setCategory(category);
            expense.setCategory(category);
        }
        Expense updatedExpense = expenseRepository.save(expense);
        return ExpenseMapper.mapToExpenseDto(updatedExpense);
    }

    @Override
    public void deleteExpense(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException("Expense not  found"));
        expenseRepository.delete(expense);
    }
}
