package com.grassparty.tft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@CrossOrigin("*")
public class TestController {

    @Autowired
    TestService testService;


    // 문자열 출력 테스트
    @GetMapping(path = "/{test}")
    public String test(@PathVariable String test) {
        return test;
    }

    // UTF-8 테스트
    @GetMapping(path = "/UTF-8/{name}")
    public String GetEncodeByName(@PathVariable String name) {
        return testService.GetEncodeByName(name);
    }
}
