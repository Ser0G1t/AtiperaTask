package com.example.atipera.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler({ WebClientResponseException.NotFound.class })
    public ResponseEntity<NotFoundException> resourceNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundException(404, "Repository or user doesn't exists"));}
}
