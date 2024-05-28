package com.med.tracker.service.impl;

import com.med.tracker.dto.ExpenseDTO;
import com.med.tracker.entity.Category;
import com.med.tracker.entity.Expense;
import com.med.tracker.exception.CategoryException;
import com.med.tracker.exception.ExpenseException;
import com.med.tracker.mapper.ExpenseMapper;
import com.med.tracker.repository.CategoryRepository;
import com.med.tracker.repository.ExpenseRepository;
import com.med.tracker.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {


   private final ExpenseRepository expenseRepository;


    private final CategoryRepository categoryRepository;

    @Override
    public ExpenseDTO createExpense(ExpenseDTO expenseDTO) {
       Expense expenseEntity=  ExpenseMapper.expenseDtoToEntity(expenseDTO);
       Expense savedExpenseEntity= expenseRepository.save(expenseEntity);
       return ExpenseMapper.expenseEntityToDto(savedExpenseEntity);

    }

    @Override
    public ExpenseDTO getExpenseById(Long expenseId) {
       Expense expense= expenseRepository.findById(expenseId).orElseThrow(()->new ExpenseException("Expense Record not found"+ expenseId));
       return ExpenseMapper.expenseEntityToDto(expense);
    }

    @Override
    public List<ExpenseDTO> getAllExpenses() {
          return expenseRepository.findAll()
                     .stream()
                     .map(ExpenseMapper::expenseEntityToDto)
                     .sorted(Comparator.comparing(ExpenseDTO::id))
                     .toList();

    }

    @Override
    public ExpenseDTO updateExpense(Long expenseId, ExpenseDTO expenseDTO) {

       Expense expense= expenseRepository.findById(expenseId).orElseThrow(()-> new ExpenseException("Expense not found with id"+expenseId));
       expense.setAmount(expenseDTO.amount());
       expense.setExpenseDate(expenseDTO.expenseDate());
       if(expenseDTO.categoryDTO() !=null){
        Category category= categoryRepository.findById(expenseDTO.categoryDTO().id()).orElseThrow(()-> new CategoryException("Category not found with id"+expenseDTO.categoryDTO().id()));
           expense.setCategory(category);
       }
       Expense savedExpense= expenseRepository.save(expense);
       return ExpenseMapper.expenseEntityToDto(savedExpense);

    }

    @Override
    public void deleteExpense(Long expenseId) {
       Expense expense= expenseRepository.findById(expenseId).orElseThrow(()-> new ExpenseException("Expense not found with id"+expenseId));
        expenseRepository.delete(expense);


    }
}
