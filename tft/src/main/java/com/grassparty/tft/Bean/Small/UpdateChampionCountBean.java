package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.StatChampionDAO;
import com.grassparty.tft.Model.DAO.StatChampionDeckCountDAO;
import com.grassparty.tft.Repository.JPA.StatChampionDeckCountRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateChampionCountBean {
    public Long exec(StatChampionDAO statChampionDAO){

        if(statChampionDAO.getCount() == null){
            statChampionDAO.setCount(0L);
        }
        Long totalCount = statChampionDAO.getCount() + 1;
        return totalCount;
    }
    //param == null || param.length() == 0
}
