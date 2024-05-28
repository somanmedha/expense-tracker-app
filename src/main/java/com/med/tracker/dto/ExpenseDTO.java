package com.med.tracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(
        description = "Expense Data Transfer Object to transfer data between client and server"
)
public record ExpenseDTO(Long id, @Schema(
        description = "Expense Amount"
) BigDecimal amount, @Schema(
        description = "Creation date"
) LocalDate expenseDate, @Schema(
        description = "Associated expense category"
) CategoryDTO categoryDTO) {
}
