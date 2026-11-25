package org.msa.msa5spring.error;

import org.msa.msa5spring.response.GlobalResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<GlobalResponseDTO<Void>> handle(MethodArgumentNotValidException) {
    // }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalResponseDTO<Void>> handle(Exception e) {
        return ResponseEntity
            .status(500)
            .body(
                new GlobalResponseDTO<>(
                        "E99",
                        "시스템 에러",
                        null
                )
            );

    }
}
