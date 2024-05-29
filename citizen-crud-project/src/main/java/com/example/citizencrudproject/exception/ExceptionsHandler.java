package com.example.citizencrudproject.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, String>> HandleExistEntityException(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap("error", "Сущность/сущности не существует/существуют"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> HandleValidationException(MethodArgumentNotValidException ex){
        String errorMessage = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap("error", errorMessage));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> HandleValidationException(){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(Collections.singletonMap("error", "Ошибка чтения тела запроса"));
    }

    @ExceptionHandler(UniqueUserException.class)
    public ResponseEntity<Map<String, String>> HandleUniqueUserException(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(Collections.singletonMap("error", "Пользователь уже существует"));
    }
}
