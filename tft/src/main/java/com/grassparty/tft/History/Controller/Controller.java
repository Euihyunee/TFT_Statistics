package com.grassparty.tft.History.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class Controller {
    @GetMapping("/")
    public String helloDTO(){ return "hello";}


}
