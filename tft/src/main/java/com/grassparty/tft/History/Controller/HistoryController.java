package com.grassparty.tft.History.Controller;

import com.grassparty.tft.History.Service.HistoryService;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Model.DTO.MetaRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/his")
@CrossOrigin("*")
public class HistoryController {
    @Autowired
    HistoryService historyService;


    // MetaRecordDTOs 닉네임으로 얻기
    @GetMapping("/GetMatchHistory/{name}")
    public MetaRecordDTO[] GetMatchHistoryByName(@PathVariable String name){return historyService.GetMatchHistoryByName(name);}

    // matchId로 matchDto를 받아오고 이를 FullRecordDTO로 변환하는 Controller
    @GetMapping(path="/GetRecord/{matchid}")
    public RecordDTO GetRecordByMatchId(@PathVariable String matchid){return historyService.GetRecordByMatchId(matchid);}
}
