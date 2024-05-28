package com.med.tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorInfo> categoryExceptionHandler(CategoryException categoryException, WebRequest webRequest){
        ErrorInfo errorInfo=new ErrorInfo(
                LocalDateTime.now(),
                categoryException.getMessage(),
                webRequest.getDescription(false),
                "CATEGORY_NOT_FOUND"
        );
        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(ExpenseException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorInfo> expenseExceptionHandler(ExpenseException expenseException, WebRequest webRequest){
        ErrorInfo errorInfo=new ErrorInfo(
                LocalDateTime.now(),
                expenseException.getMessage(),
                webRequest.getDescription(false),
                "EXPENSE_NOT_FOUND"
        );
        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorInfo> genericExceptionHandler(Exception exception, WebRequest webRequest){
        ErrorInfo errorInfo=new ErrorInfo(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "INTERNAL_SERVER_ERROR"
        );
        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);

    }
}
