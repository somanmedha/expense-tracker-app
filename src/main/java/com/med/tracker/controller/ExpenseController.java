package com.med.tracker.controller;

import com.med.tracker.dto.ExpenseDTO;
import com.med.tracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

     @PostMapping("/create-expense")
    public ResponseEntity<ExpenseDTO> createExpense(@RequestBody ExpenseDTO expenseDTO){
       ExpenseDTO savedExpense= expenseService.createExpense(expenseDTO);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDTO> getExpenseById(@PathVariable("id") Long expenseId){
        ExpenseDTO expenseDTO= expenseService.getExpenseById(expenseId);
        return ResponseEntity.ok(expenseDTO);


    }

    @GetMapping
    public ResponseEntity<List<ExpenseDTO>> fetchAllExpenses(){
       List<ExpenseDTO> expenseList =expenseService.getAllExpenses();
       return ResponseEntity.ok(expenseList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ExpenseDTO>  updateExpense(@PathVariable("id") Long expenseId, @RequestBody ExpenseDTO expenseDTO){
       ExpenseDTO updatedExpense= expenseService.updateExpense(expenseId,expenseDTO);
        return ResponseEntity.ok(updatedExpense);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long expenseId){
        expenseService.deleteExpense(expenseId);
        return ResponseEntity.ok("Expense deleted successfully");
    }


}
