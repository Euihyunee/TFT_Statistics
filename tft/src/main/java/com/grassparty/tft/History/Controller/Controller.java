package com.grassparty.tft.History.Controller;

import com.grassparty.tft.History.Service.HistoryService;
import com.grassparty.tft.Model.DTO.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@CrossOrigin("*")
public class Controller {
    @Autowired
    HistoryService historyService;

    @GetMapping("/")
    public String helloDTO(){ return "forward:/index.html";}

    // TODO 유저 정보 제공 (UserInfoDTO)
    @GetMapping("/user/{userName}")
    public UserInfoDTO GetUserInfo(@PathVariable String userName){
        return historyService.GetUserInfo(userName);
    }


}
