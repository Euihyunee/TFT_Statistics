package com.grassparty.tft.History.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class Controller {
    @GetMapping("/")
    public String helloDTO(){ return "hello";}

    @GetMapping("/user")
    public String GetUser(){
        return "user 데이터";
    }

    @GetMapping("/unit")
    public String GetUnit(){
        return "unit 데이터";
    }

    @GetMapping("/item")
    public String GetItem(){
        return "item 데이터";
    }

    @GetMapping("/champ")
    public String GetChamp(){
        return "champ 데이터";
    }

}
