package com.grassparty.tft.History.Controller;

import com.grassparty.tft.History.Service.HistoryService;
import com.grassparty.tft.Model.DTO.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class Controller {
    @Autowired
    HistoryService historyService;

    @GetMapping("/")
    public String helloDTO(){ return "hello";}

    // TODO 유저 정보 제공 (UserInfoDTO)
    @GetMapping("/user")
    public UserInfoDTO GetUserInfo(){
        return historyService.GetUserInfo();
    }


}
