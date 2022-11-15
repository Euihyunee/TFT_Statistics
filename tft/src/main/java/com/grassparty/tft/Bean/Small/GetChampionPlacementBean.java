package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.StatChampionDAO;
import org.springframework.stereotype.Component;

@Component
public class GetChampionPlacementBean {

    public Long exec(StatChampionDAO statChampionDAO, int placement){

        if(statChampionDAO.getPlacement() == null){
            statChampionDAO.setPlacement(0L);
        }
        Long totalCount = statChampionDAO.getPlacement() + placement;
        return totalCount;
    }
}
