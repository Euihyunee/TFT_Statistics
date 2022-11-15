package com.grassparty.tft.Bean;

import com.grassparty.tft.Model.DAO.StatChampionDAO;
import com.grassparty.tft.Model.DAO.StatChampionDeckCountDAO;
import com.grassparty.tft.Model.DAO.StatChampionResultDAO;
import com.grassparty.tft.Repository.JPA.StatChampionDeckCountRepositoryJPA;
import com.grassparty.tft.Repository.JPA.StatChampionRepositoryJPA;
import com.grassparty.tft.Repository.JPA.StatChampionResultRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateStatChampionResultDAOBean {
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
            double averagePlacement =  (double)statChampionDAO.getPlacement() / statChampionDAO.getCount();
            if (statChampionDAO.getThreeStarCount() == null) {
                statChampionDAO.setThreeStarCount(0L);
                statChampionDAO.setThreeStarPlacement(0L);
                statChampionResultDAO.setThreeStarFrequency(0L);
                statChampionResultDAO.setThreeStarAveragePlacement(0L);
            }
            double threeStarFrequency =  (double)statChampionDAO.getThreeStarCount() / totalDeckCount;
            double threeStarAveragePlacement = 0;
            if(statChampionDAO.getThreeStarCount() != 0) {
                threeStarAveragePlacement = (double) statChampionDAO.getThreeStarPlacement() / statChampionDAO.getThreeStarCount();
            }


            // Math.round(num * 100) / 100.0;
            statChampionResultDAO.setFrequency(Math.round(frequency*1000) / 1000.0);
            statChampionResultDAO.setAveragePlacement(Math.round(averagePlacement*1000) / 1000.0);
            statChampionResultDAO.setThreeStarFrequency(Math.round(threeStarFrequency*1000) / 1000.0);
            statChampionResultDAO.setThreeStarAveragePlacement(Math.round(threeStarAveragePlacement*1000) / 1000.0);

            statChampionResultRepositoryJPA.save(statChampionResultDAO);

        }
    }


}
