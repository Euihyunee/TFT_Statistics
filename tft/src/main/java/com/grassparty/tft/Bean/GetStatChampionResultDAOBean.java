package com.grassparty.tft.Bean;

import com.grassparty.tft.Model.DAO.StatChampionDAO;
import com.grassparty.tft.Model.DAO.StatChampionDeckCountDAO;
import com.grassparty.tft.Model.DAO.StatChampionResultDAO;
import com.grassparty.tft.Repository.JPA.StatChampionDeckCountRepositoryJPA;
import com.grassparty.tft.Repository.JPA.StatChampionRepositoryJPA;
import com.grassparty.tft.Repository.JPA.StatChampionResultRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetStatChampionResultDAOBean {
    @Autowired
    StatChampionRepositoryJPA statChampionRepositoryJPA;
    @Autowired
    StatChampionDeckCountRepositoryJPA statChampionDeckCountRepositoryJPA;
    @Autowired
    StatChampionResultRepositoryJPA statChampionResultRepositoryJPA;

    /*
    champion_id : StatChampion 테이블에서 가져옴
    version_id : StatChampion 테이블에서 가져옴
    frequency = count / total_deck_count (stat_champion_deck_count 테이블)
    average_placement = placement / total_deck_count (stat_champion_deck_count 테이블)
    three_star_frequency = three_star_count / total_deck_count (stat_champion_deck_count 테이블)
    three_star_average_placement = three_star_placement / total_deck_count (stat_champion_deck_count 테이블)
     */

    public void exec(){
        List<StatChampionDAO> statChampionDAOList = statChampionRepositoryJPA.findAll();

        for (StatChampionDAO statChampionDAO : statChampionDAOList) {
            StatChampionDeckCountDAO statChampionDeckCountDAO = statChampionDeckCountRepositoryJPA.findByVersionId(statChampionDAO.getVersionId());
            Long totalDeckCount = statChampionDeckCountDAO.getTotalDeckCount();

            StatChampionResultDAO statChampionResultDAO = new StatChampionResultDAO();
            statChampionResultDAO.setChampionId(statChampionDAO.getChampionName());
            statChampionResultDAO.setVersionId(statChampionDAO.getVersionId());

            double frequency =  (double)statChampionDAO.getCount() / totalDeckCount;
            double averagePlacement =  (double)statChampionDAO.getPlacement() / totalDeckCount;
            if (statChampionDAO.getThreeStarCount() == null) {
                statChampionDAO.setThreeStarCount(0L);
                statChampionDAO.setThreeStarPlacement(0L);
                statChampionResultDAO.setThreeStarFrequency(0);
                statChampionResultDAO.setThreeStarAveragePlacement(0);
            }
            double threeStarFrequency =  (double)statChampionDAO.getThreeStarCount() / totalDeckCount;
            double threeStarAveragePlacement =  (double)statChampionDAO.getThreeStarPlacement() / totalDeckCount;

            statChampionResultDAO.setFrequency(frequency);
            statChampionResultDAO.setAveragePlacement(averagePlacement);
            statChampionResultDAO.setThreeStarFrequency(threeStarFrequency);
            statChampionResultDAO.setThreeStarAveragePlacement(threeStarAveragePlacement);

            statChampionResultRepositoryJPA.save(statChampionResultDAO);

        }
    }


}
