package com.example.aopnullablereturncheck.system;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {

    @ExceptionHandler(NullableChecker.NullableCheckException.class)
    public ResponseEntity<Object> handleNullableCheckException() {
        final Map<String, String> errorMap = Map.of("message", "Nullableチェックエラーです。");
        return ResponseEntity.badRequest().body(errorMap);
    }

}
