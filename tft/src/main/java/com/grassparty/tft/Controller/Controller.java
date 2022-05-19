package com.grassparty.tft.Controller;

import com.grassparty.tft.Model.Riot.SummonerDTO;
import com.grassparty.tft.Service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    private SummonerService service = new SummonerService();


    @GetMapping("/")
    public String helloDTO(){ return "hello";}

    @GetMapping(path="/puuid/{puuid}")
    public SummonerDTO GetDTOByPuuid(@PathVariable String puuid){ return service.GetSummonerDtoByPuuid(puuid);}

    @GetMapping(path="/name/{name}")
    public SummonerDTO GetDTOByName(@PathVariable String name){ return service.GetSummonerDTOByName(name);}

    @GetMapping(path="/test/{test}")
    public String test(@PathVariable String test){ return test;}

    @GetMapping(path="/UTF-8/{name}")
    public String GetEncodeByName(@PathVariable String name){ return service.GetEncode(name);}

}
