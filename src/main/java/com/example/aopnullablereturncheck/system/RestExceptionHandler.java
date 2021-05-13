package com.example.aopnullablereturncheck.system;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {

    @ExceptionHandler(NullableCheckException.class)
    public ResponseEntity<Object> handleNullableCheckException(NullableCheckException e) {
        log.error(e.getMessage(), e);
        final Map<String, String> errorMap = Map.of("message", "システムエラーです");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMap);
    }

}
