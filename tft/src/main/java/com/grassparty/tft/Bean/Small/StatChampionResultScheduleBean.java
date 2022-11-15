package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Bean.UpdateStatChampionResultDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatChampionResultScheduleBean {
    @Autowired
    UpdateStatChampionResultDAOBean updateStatChampionResultDAOBean;


    public void exec(){
        // StatChampion에 있는 데이터로 StatChampionResult 최신화 또는 생성
        updateStatChampionResultDAOBean.exec();
    }
}
