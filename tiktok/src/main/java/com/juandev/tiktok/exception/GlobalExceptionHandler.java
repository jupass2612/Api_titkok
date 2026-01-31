package com.juandev.tiktok.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsuarioYaExisteException.class)
    public ResponseEntity<?> usuarioExiste(UsuarioYaExisteException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "timestamp", LocalDateTime.now(),
                "status", 400,
                "error", "Bad Request",
                "message", ex.getMessage()
        ));
    }

    @ExceptionHandler(CredencialesInvalidasException.class)
    public ResponseEntity<?> loginError(CredencialesInvalidasException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                "timestamp", LocalDateTime.now(),
                "status", 401,
                "error", "Unauthorized",
                "message", ex.getMessage()
        ));
    }
}
