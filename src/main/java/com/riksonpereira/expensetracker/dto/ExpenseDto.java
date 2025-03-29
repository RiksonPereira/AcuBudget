package com.riksonpereira.expensetracker.dto;

import java.util.Date;

public record ExpenseDto(Long id,
                         Date expenseDate,
                         CategoryDto categoryDto,
                         Double amount,
                         String discription
                         ) {
}
