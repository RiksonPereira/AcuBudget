package com.riksonpereira.expensetracker.service;

import com.riksonpereira.expensetracker.dto.ExpenseDto;
import com.riksonpereira.expensetracker.entity.Expense;

import java.util.List;

public interface ExpenseService {
    ExpenseDto createExpense(ExpenseDto expenseDtp);
    ExpenseDto getExpenseById(Long id);
    List<ExpenseDto> getExpensesByCategory(String category);
    List<ExpenseDto> getAllExpenses();
    Double getTotalExpenses();
    ExpenseDto updateExpense(Long id, ExpenseDto expenseDto);
    void deleteExpense(Long id);
}
