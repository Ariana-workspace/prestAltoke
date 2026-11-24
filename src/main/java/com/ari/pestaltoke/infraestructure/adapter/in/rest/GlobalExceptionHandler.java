package com.ari.pestaltoke.infraestructure.adapter.in.rest;

import com.ari.pestaltoke.domain.exception.CredencialesInvalidasException;
import com.ari.pestaltoke.domain.exception.EmailYaRegistradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CredencialesInvalidasException.class)
    public ResponseEntity<Map<String, String>> credenciales(CredencialesInvalidasException e) {
        return ResponseEntity.status(401).body(Map.of("error", e.getMessage()));
    }

    @ExceptionHandler(EmailYaRegistradoException.class)
    public ResponseEntity<Map<String, String>> emailRepetido(EmailYaRegistradoException e) {
        return ResponseEntity.status(409).body(Map.of("error", e.getMessage()));
    }
}