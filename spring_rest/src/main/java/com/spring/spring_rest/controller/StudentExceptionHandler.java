package com.spring.spring_rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.spring_rest.entity.StudentErrorResponse;
import com.spring.spring_rest.exception.StudentNotFoundException;

/**
 * Global exception handler for student-related REST endpoints.
 */
@ControllerAdvice
public class StudentExceptionHandler {

    /**
     * Handles {@link StudentNotFoundException} when a student record
     * cannot be found.
     *
     * @param ex the thrown {@code StudentNotFoundException}
     * @return a {@code ResponseEntity} containing the error details
     *         and HTTP 404 status
     */
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(
            StudentNotFoundException ex) {

        StudentErrorResponse err = new StudentErrorResponse();

        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(ex.getMessage());
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles general exceptions thrown by invalid request inputs.
     *
     * @param ex the thrown {@code Exception}
     * @return a {@code ResponseEntity} containing the error details
     *         and HTTP 400 status
     */
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(
            Exception ex) {

        StudentErrorResponse err = new StudentErrorResponse();

        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage(
                "Invalid data. Only integers are accepted");
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

}