package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.StatChampionDAO;
import org.springframework.stereotype.Component;

@Component
public class GetChampionCountBean {
    public Long exec(StatChampionDAO statChampionDAO){

        if(statChampionDAO.getCount() == null){
            statChampionDAO.setCount(0L);
        }
        Long totalCount = statChampionDAO.getCount() + 1;
        return totalCount;
    }
    //param == null || param.length() == 0
}
