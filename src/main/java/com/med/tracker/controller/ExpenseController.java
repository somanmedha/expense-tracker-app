package com.med.tracker.controller;

import com.med.tracker.dto.ExpenseDTO;
import com.med.tracker.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Expense Resource",
        description = "CRUD REST APIs for Expense Resource- " + "Create Expense, Update Expense, Get Expense,Get All expenses and Delete Expense"
)
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Operation(
            summary = "Create Expense REST API",
            description = "Create Expense REST API to save an expense in a database"
    )

    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"

    )
    @PostMapping("/create-expense")
    public ResponseEntity<ExpenseDTO> createExpense(@RequestBody ExpenseDTO expenseDTO) {
        ExpenseDTO savedExpense = expenseService.createExpense(expenseDTO);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);

    }

    @Operation(
            summary = "Get Expense REST API",
            description = "GET Expense REST API to get an expense from the database based on expense id"
    )

    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"

    )
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDTO> getExpenseById(@PathVariable("id") Long expenseId) {
        ExpenseDTO expenseDTO = expenseService.getExpenseById(expenseId);
        return ResponseEntity.ok(expenseDTO);

    }

    @Operation(
            summary = "Get all expenses REST API",
            description = "GET all expenses REST API to get a list of expenses from the database"
    )

    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"

    )

    @GetMapping
    public ResponseEntity<List<ExpenseDTO>> fetchAllExpenses() {
        List<ExpenseDTO> expenseList = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenseList);
    }

    @Operation(
            summary = "Update expense REST API",
            description = "Update Expense REST API to update an existing expense in the database"
    )

    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"

    )

    @PutMapping("/update/{id}")
    public ResponseEntity<ExpenseDTO> updateExpense(@PathVariable("id") Long expenseId, @RequestBody ExpenseDTO expenseDTO) {
        ExpenseDTO updatedExpense = expenseService.updateExpense(expenseId, expenseDTO);
        return ResponseEntity.ok(updatedExpense);

    }


    @Operation(
            summary = "Delete expense REST API",
            description = "Delete Expense REST API to delete an expense from the database"
    )

    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"

    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long expenseId) {
        expenseService.deleteExpense(expenseId);
        return ResponseEntity.ok("Expense deleted successfully");
    }


}
