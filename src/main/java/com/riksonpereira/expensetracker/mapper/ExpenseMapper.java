package com.riksonpereira.expensetracker.mapper;

import com.riksonpereira.expensetracker.dto.CategoryDto;
import com.riksonpereira.expensetracker.dto.ExpenseDto;
import com.riksonpereira.expensetracker.entity.Category;
import com.riksonpereira.expensetracker.entity.Expense;

public class ExpenseMapper {
    public static ExpenseDto mapToExpenseDto(Expense expense) {
        return new ExpenseDto(
                expense.getId(),
                expense.getExpenseDate(),
                new CategoryDto(
                        expense.getCategory().getId(),
                        expense.getCategory().getName()
                ),
                expense.getAmount(),

                expense.getDescription()
        );
    }
    public static Expense mapToExpense(ExpenseDto expenseDto) {
        Category category = new Category();
        category.setId(expenseDto.categoryDto().id());
        return new Expense(
                expenseDto.id(),
                expenseDto.expenseDate(),
                category,
                expenseDto.amount(),
                expenseDto.description()

        );
    }
}
