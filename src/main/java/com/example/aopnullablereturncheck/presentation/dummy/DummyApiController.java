package com.example.aopnullablereturncheck.presentation.dummy;

import com.example.aopnullablereturncheck.application.DummyApplicationService;
import com.example.aopnullablereturncheck.application.DummyResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("api")
@RestController
@RequiredArgsConstructor
public class DummyApiController {

    private final DummyApplicationService dummyApplicationService;

    @GetMapping("getnullable")
    public ResponseEntity<Object> nullableReturn() {
        final DummyResult dummyResult = dummyApplicationService.getNullableDummyResult();
        /*
        if (dummyResult == null) {
            final Map<String, String> errorMap = Map.of("message", "値がnullです。");
            return ResponseEntity.badRequest().body(errorMap);
        }

         */
        final DummyResponse dummyResponse = new DummyResponse(dummyResult.getData());
        return ResponseEntity.ok(dummyResponse);
    }

    @GetMapping("getnotnull")
    public ResponseEntity<Object> notNullReturn() {
        final DummyResult dummyResult = dummyApplicationService.getNotNullDummyResult();
        /*
        if (dummyResult == null) {
            final Map<String, String> errorMap = Map.of("message", "値がnullです。");
            return ResponseEntity.badRequest().body(errorMap);
        }

         */
        final DummyResponse dummyResponse = new DummyResponse(dummyResult.getData());
        return ResponseEntity.ok(dummyResponse);
    }

}
