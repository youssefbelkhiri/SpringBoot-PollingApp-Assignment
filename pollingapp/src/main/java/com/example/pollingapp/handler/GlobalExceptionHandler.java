package com.example.pollingapp.handler;

import com.example.pollingapp.poll.PollNotFoundExcepetion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PollNotFoundExcepetion.class)
    public ResponseEntity<String> handle(PollNotFoundExcepetion excepetion) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(excepetion.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException excepetions) {

        var errors = new HashMap<String , String>();

        excepetions.getBindingResult().getAllErrors().forEach(error -> {
           var filedError = ((FieldError)error ).getField();
           var message = error.getDefaultMessage();
           errors.put(filedError, message);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
    }
}
