package com.grassparty.tft.History.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class Controller {
    @GetMapping("/")
    public String helloDTO(){ return "hello";}

    // TODO 유저 정보 제공 (UserInfoDTO)
    @GetMapping("/user")
    public String GetUser(){
        return "user 데이터";
    }


}
