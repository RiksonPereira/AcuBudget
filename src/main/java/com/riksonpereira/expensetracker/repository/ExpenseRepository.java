package com.riksonpereira.expensetracker.repository;

import com.riksonpereira.expensetracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByCategory_Name(String category);
}
