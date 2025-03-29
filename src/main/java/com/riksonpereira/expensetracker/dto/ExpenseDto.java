package com.riksonpereira.expensetracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(
        description ="Expense Dto - to transfer the data between client and server"
)
public record ExpenseDto(Long id,
                         @Schema(
                                 description = "Expense creation date"
                         )
                         Date expenseDate,
                         @Schema(
                                 description = "Associated Expense Category"
                         )
                         CategoryDto categoryDto,
                         @Schema(
                                 description = "Expense Amount"
                         )
                         Double amount,
                         @Schema(
                                 description = "Expense Description"
                         )
                         String description
                         ) {
}
