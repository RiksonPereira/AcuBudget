package com.riksonpereira.expensetracker.controller;

import com.riksonpereira.expensetracker.dto.ExpenseDto;
import com.riksonpereira.expensetracker.entity.Expense;
import com.riksonpereira.expensetracker.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs For Expense Resource",
        description = "CRUD REST APIs For Expense Resource - Create Expense" +
                "Update Expense, Get Expense & Delete Expense"
)
@AllArgsConstructor
@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private ExpenseService expenseService;

    @Operation(
            summary = "Create Expense - REST API",
            description ="REST endpoint to save Expense into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto) {
        ExpenseDto expense = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(expense, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Specific Expense - REST API",
            description ="REST endpoint to get the Expense from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable("id") Long id) {
        ExpenseDto expense = expenseService.getExpenseById(id);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Expenses - REST API",
            description ="REST endpoint to get all the Expenses from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        List<ExpenseDto> expenses = expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @Operation(
            summary = "Update Expense - REST API",
            description ="REST endpoint to update the Expense in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @PutMapping("{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable("id") Long id, @RequestBody ExpenseDto expenseDto) {
        ExpenseDto expense = expenseService.updateExpense(id, expenseDto);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Expense - REST API",
            description ="REST endpoint to delete the Expense from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Deleted Successfully!");
    }

    @Operation(
            summary = "Delete Expense - REST API",
            description ="REST endpoint to get total Expense"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("/totalExpense")
    public ResponseEntity<Double> totalExpenses() {
        Double totalExpenses = expenseService.getTotalExpenses();
        return new ResponseEntity<>(totalExpenses, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Expense - REST API",
            description ="REST endpoint to get the Expense by Category from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("/byCategory/{category}")
    public ResponseEntity<List<ExpenseDto>> getExpensesByCategory(@PathVariable("category") String category) {
        List<ExpenseDto> expenses = expenseService.getExpensesByCategory(category);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }
}
