package com.grassparty.tft.Stat.Controller;

import com.grassparty.tft.Bean.GetStatChampionDeckCountBean;
import com.grassparty.tft.Bean.Small.GetVersionBean;
import com.grassparty.tft.Model.DAO.VersionDAO;
import com.grassparty.tft.Model.DTO.StatDeckDTO;
import com.grassparty.tft.Model.DTO.StatItemDTOs;
import com.grassparty.tft.Model.DTO.StatUnitDTOs;
import com.grassparty.tft.Stat.Service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stat")
@CrossOrigin("*")
public class StatController {
    @Autowired
    StatService statService;
    @Autowired
    GetVersionBean getVersionBean;
    @Autowired
    GetStatChampionDeckCountBean getStatChampionDeckCountBean;

    // TODO 덱 티어리스트 제공 (StatDeckDTO)
    @GetMapping("/champ")
    public StatDeckDTO GetChamp(){
        return null;
    }
    @GetMapping("/champion")
    public VersionDAO GetVersion(){
        getStatChampionDeckCountBean.exec();

        return null;
    }



    // TODO 챔피언 티어리스트 제공 (StatUnitDTOs)
    @GetMapping("/unit")
    public StatUnitDTOs GetUnit(){
        return null;
    }

    // TODO 아이템 티어리스트 제공 (StatItemDTOs)
    @GetMapping("/item")
    public StatItemDTOs GetItem(){
        return null;
    }


    // 통계 로직에 데이터 넣기
    @GetMapping(path="/put/{name}")
    public void PutStatistic(@PathVariable String name){ statService.PutRecordForStatByName(name);}

    // 통계 로직 실행
    @GetMapping(path="/start")
    public void StartStatistic(){ statService.StartStatistic(); }

}
