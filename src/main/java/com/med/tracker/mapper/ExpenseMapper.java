package com.med.tracker.mapper;

import com.med.tracker.dto.CategoryDTO;
import com.med.tracker.dto.ExpenseDTO;
import com.med.tracker.entity.Category;
import com.med.tracker.entity.Expense;

public class ExpenseMapper {

    public static ExpenseDTO expenseEntityToDto(Expense expense) {
        return new ExpenseDTO(
                expense.getExpenseId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDTO(
                        expense.getCategory().getId(),
                        expense.getCategory().getName()
                )
        );
    }

    public static Expense expenseDtoToEntity (ExpenseDTO expenseDTO){

        Category category=new Category();
        category.setId(expenseDTO.categoryDTO().id());
        return new Expense(
                expenseDTO.id(),
                expenseDTO.amount(),
                expenseDTO.expenseDate(),
                category
        );

    }
}


