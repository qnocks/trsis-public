package ru.qnocks.trsis.lab2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.ZonedDateTime;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiException> handleValidationExceptions(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(
                new ApiException(e.getAllErrors().toString() , HttpStatus.BAD_REQUEST, ZonedDateTime.now()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiException> handleException(IllegalArgumentException e) {
        return new ResponseEntity<>(
                new ApiException(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now()),
                HttpStatus.BAD_REQUEST
        );
    }
}
