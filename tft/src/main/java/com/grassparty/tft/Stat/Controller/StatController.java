package com.grassparty.tft.Stat.Controller;

import com.grassparty.tft.Bean.SaveStatChampionDAOBean;
import com.grassparty.tft.Bean.SaveStatChampionDeckCountBean;
import com.grassparty.tft.Bean.Small.GetStatChampionResultBean;
import com.grassparty.tft.Bean.UpdateStatChampionResultDAOBean;
import com.grassparty.tft.Bean.Small.SaveVersionBean;
import com.grassparty.tft.Model.DAO.StatChampionResultDAO;
import com.grassparty.tft.Model.DAO.VersionDAO;
import com.grassparty.tft.Model.DTO.StatDeckDTO;
import com.grassparty.tft.Model.DTO.StatItemDTOs;
import com.grassparty.tft.Model.DTO.StatUnitDTOs;
import com.grassparty.tft.Stat.Service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stat")
@CrossOrigin("*")
public class StatController {
    @Autowired
    StatService statService;
    @Autowired
    SaveVersionBean saveVersionBean;
    @Autowired
    SaveStatChampionDeckCountBean saveStatChampionDeckCountBean;
    @Autowired
    SaveStatChampionDAOBean saveStatChampionDAOBean;
    @Autowired
    UpdateStatChampionResultDAOBean updateStatChampionResultDAOBean;
    @Autowired
    GetStatChampionResultBean getStatChampionResultBean;

    @Autowired
    Mocker mocker;


    // TODO 덱 티어리스트 제공 (StatDeckDTO)
    @GetMapping("/deck")
    public List<StatDeckDTO> GetChamp(){
        return mocker.GetMockDeck();
    }

    // TODO 챔피언 티어리스트 제공 (StatUnitDTOs)
    @GetMapping("/unit")
    public StatUnitDTOs GetUnit(){
        return null;
    }

    // TODO 아이템 티어리스트 제공 (StatItemDTOs)
    @GetMapping("/item")
    public StatItemDTOs GetItem(){
        return mocker.GetMockItem();
    }


    @GetMapping("/champion")
    public List<StatChampionResultDAO> GetStatChampionResult(){
        return getStatChampionResultBean.exec();
    }

    // 여기에 RecordDTO 낱개 넣으면 됨
    @GetMapping("/statchampion")
    public void GetStatChampion(){
//        getStatChampionDAOBean.exec(RecordDTO recordDTO);
//        getStatChampionDeckCountBean.exec(RecordDTO recordDTO);
    }
    @GetMapping("/statresult")
    public void GetStatResult(){
        updateStatChampionResultDAOBean.exec();
    }

    // 통계 로직에 데이터 넣기
    @GetMapping(path="/put/{name}")
    public void PutStatistic(@PathVariable String name){ statService.PutRecordForStatByName(name);}

    // 통계 로직 실행
    @GetMapping(path="/start")
    public void StartStatistic(){ statService.StartStatistic(); }

}
