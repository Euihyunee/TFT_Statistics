package com.grassparty.tft.Bean.Small;


import com.grassparty.tft.Model.DAO.StatChampionDAO;
import org.springframework.stereotype.Component;

@Component
public class GetChampionThreeStarPlacementBean {

    public Long exec(StatChampionDAO statChampionDAO, int placement) {

        if(statChampionDAO.getThreeStarPlacement() == null){
            statChampionDAO.setThreeStarPlacement(0L);
        }
        Long threeStarPlacement = statChampionDAO.getThreeStarPlacement() + placement;

        return threeStarPlacement;
    }
}
