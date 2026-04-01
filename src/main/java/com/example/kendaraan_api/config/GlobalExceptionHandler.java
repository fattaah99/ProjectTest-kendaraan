package com.example.kendaraan_api.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.kendaraan_api.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(RuntimeException ex) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getMessage(), 404),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneral(Exception ex) {
        return new ResponseEntity<>(
                new ErrorResponse("Terjadi kesalahan server", 500),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
