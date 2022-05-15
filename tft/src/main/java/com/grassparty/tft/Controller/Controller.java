package com.grassparty.tft.Controller;

import com.grassparty.tft.Model.Riot.SummonerDTO;
import com.grassparty.tft.Service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private SummonerService service = new SummonerService();


    @GetMapping("/")
    public SummonerDTO HelloDTO(){
        return service.GetSummonerDtoByPuuid();
    }

}
