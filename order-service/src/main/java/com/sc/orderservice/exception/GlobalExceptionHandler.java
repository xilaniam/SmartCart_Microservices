package com.sc.orderservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class) //for the validation checks
    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(err-> errors.put(err.getField(),err.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
    }
    @ExceptionHandler(EmptyProductStockException.class)
    public ResponseEntity<Map<String,String>> handleEmptyProductStockException(Exception e){
        Map<String,String> err = new HashMap<>();
        err.put("message","there are no items on the inventory");
        return ResponseEntity.badRequest().body(err);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String ,String>> handleProductNotFoundException(Exception ex){
        Map<String,String> err = new HashMap<>();
        err.put("message" , "The product is not found !");
        err.put("exception message ",ex.getMessage());
        return ResponseEntity.badRequest().body(err);
    }
}
