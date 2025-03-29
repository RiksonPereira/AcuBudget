package com.riksonpereira.expensetracker.controller;

import com.riksonpereira.expensetracker.dto.ExpenseDto;
import com.riksonpereira.expensetracker.entity.Expense;
import com.riksonpereira.expensetracker.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto) {
        ExpenseDto expense = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(expense, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable("id") Long id) {
        ExpenseDto expense = expenseService.getExpenseById(id);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        List<ExpenseDto> expenses = expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable("id") Long id, @RequestBody ExpenseDto expenseDto) {
        ExpenseDto expense = expenseService.updateExpense(id, expenseDto);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ExpenseDto> deleteExpense(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/totalExpense")
    public ResponseEntity<Double> totalExpenses() {
        Double totalExpenses = expenseService.getTotalExpenses();
        return new ResponseEntity<>(totalExpenses, HttpStatus.OK);
    }

    @GetMapping("/byCategory/{category}")
    public ResponseEntity<List<ExpenseDto>> getExpensesByCategory(@PathVariable("category") String category) {
        List<ExpenseDto> expenses = expenseService.getExpensesByCategory(category);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }
}
