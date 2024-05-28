package com.med.tracker.service;

import com.med.tracker.dto.ExpenseDTO;

import java.util.List;


public interface ExpenseService {

    ExpenseDTO createExpense(ExpenseDTO expenseDTO);
    ExpenseDTO getExpenseById(Long expenseId);
    List<ExpenseDTO> getAllExpenses();
    ExpenseDTO updateExpense(Long expenseId, ExpenseDTO expenseDTO);
    void deleteExpense(Long expenseId);

}
