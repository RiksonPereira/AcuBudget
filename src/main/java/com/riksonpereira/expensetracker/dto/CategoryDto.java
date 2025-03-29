package com.riksonpereira.expensetracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "Category Dto - to transfer the data between client and server"
)
public record CategoryDto(Long id,
                          @Schema(
                                  description = "Category Name"
                          )
                          String name) {
}
