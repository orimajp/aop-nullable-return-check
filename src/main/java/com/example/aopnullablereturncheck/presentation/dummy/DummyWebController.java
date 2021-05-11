package com.example.aopnullablereturncheck.presentation.dummy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
@RequiredArgsConstructor
public class DummyWebController {


    @GetMapping
    public String index() {
        return "index";
    }

}
