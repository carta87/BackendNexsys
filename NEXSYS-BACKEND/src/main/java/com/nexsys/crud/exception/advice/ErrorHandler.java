package com.nexsys.crud.exception.advice;

import com.nexsys.crud.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDTO> runtimeExceptionHandler(RuntimeException exception) {
        ErrorDTO error = ErrorDTO.builder()
                .code("S-500")
                .message(exception.getMessage())
                .build();
        if(exception.getMessage().contains("value in images must be a URL address"))
            error.setMessage("Formato no permitido en imagen");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(value = IllegalAccessException.class)
    public ResponseEntity<ErrorDTO> illegalAccessExceptionHandler(IllegalAccessException exception) {
        ErrorDTO error = ErrorDTO.builder()
                .code("S-400")
                .message(exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
