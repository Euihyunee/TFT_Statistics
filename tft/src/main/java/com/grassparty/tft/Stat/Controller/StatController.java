package com.grassparty.tft.Stat.Controller;

import com.grassparty.tft.Stat.Service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stat")
@CrossOrigin("*")
public class StatController {
    @Autowired
    StatService statService;

    // TODO 덱 티어리스트 제공 (StatDeckDTO)
    @GetMapping("/champ")
    public StatDeckDTO GetChamp(){
        return "champ 데이터";
    }

    // TODO 챔피언 티어리스트 제공 (StatUnitDTOs)
    @GetMapping("/unit")
    public StatUnitDTOs GetUnit(){
        return "unit 데이터";
    }

    // TODO 아이템 티어리스트 제공 (StatItemDTOs)
    @GetMapping("/item")
    public StatItemDTOs GetItem(){
        return "item 데이터";
    }


    // 통계 로직에 데이터 넣기
    @GetMapping(path="/stat/{name}")
    public void StartStatistic(@PathVariable String name){ statService.StatisticsByName(name);}

}
