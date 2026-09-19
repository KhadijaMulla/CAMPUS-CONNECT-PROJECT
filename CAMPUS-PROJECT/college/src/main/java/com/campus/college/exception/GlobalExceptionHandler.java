package com.campus.college.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationErrors(
            MethodArgumentNotValidException exception) {

        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage())
                );

        return errors;
    }

    @ExceptionHandler(OpportunityNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleOpportunityNotFound(
            OpportunityNotFoundException exception) {

        Map<String, String> error = new HashMap<>();

        error.put("message", exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(StudentNotFoundException.class)
public ResponseEntity<Map<String, String>> handleStudentNotFound(
        StudentNotFoundException exception) {

    Map<String, String> error = new HashMap<>();

    error.put("message", exception.getMessage());

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
}

@ExceptionHandler(ApplicationNotFoundException.class)
public ResponseEntity<Map<String, String>> handleApplicationNotFound(
        ApplicationNotFoundException exception) {

    Map<String, String> error = new HashMap<>();

    error.put("message", exception.getMessage());

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
}
}