package com.med.tracker.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseDTO(Long id, BigDecimal amount, LocalDate expenseDate, CategoryDTO categoryDTO) {
}
