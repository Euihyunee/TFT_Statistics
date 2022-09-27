package com.grassparty.tft.History.Controller;

import com.grassparty.tft.History.Service.*;
import com.grassparty.tft.Model.DTO.FullRecordDTO;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import com.grassparty.tft.Model.DTO.MetaRecordDTO;
import com.grassparty.tft.Repository.FullRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class Controller {
    @GetMapping("/")
    public String helloDTO(){ return "hello";}


}
