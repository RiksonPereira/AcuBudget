package com.riksonpereira.expensetracker.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(
        description = "Error Details DTO - to transfer error response data between client ans server"
)
@Getter
@Setter
public class ErrorDetails {
    @Schema(
            description = "Error occurrence Date and time"
    )
    private LocalDateTime timestamp;
    @Schema(
            description = "Error Message"
    )
    private String message;
    @Schema(
            description = "Error Details"
    )
    private String details;
    @Schema(
            description = "Error Code"
    )
    private String errorCode;
}