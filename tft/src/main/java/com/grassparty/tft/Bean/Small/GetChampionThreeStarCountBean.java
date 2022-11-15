package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.StatChampionDAO;
import org.springframework.stereotype.Component;

@Component
public class GetChampionThreeStarCountBean {

    public Long exec(StatChampionDAO statChampionDAO){
        if(statChampionDAO.getThreeStarCount() == null){
            statChampionDAO.setThreeStarCount(0L);
        }
        Long threeStarCount = statChampionDAO.getThreeStarCount() + 1;

        return threeStarCount;
    }
}
