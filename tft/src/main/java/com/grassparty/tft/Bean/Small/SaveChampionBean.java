package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.ChampionDAO;
import com.grassparty.tft.Repository.JPA.ChampionRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveChampionBean {

    @Autowired
    ChampionRepositoryJPA championRepositoryJPA;
    @Autowired
    GetParserChampionIdBean getParserChampionIdBean;

    public void exec(String championId) {
        String championName = getParserChampionIdBean.exec(championId);

        ChampionDAO championDAO = new ChampionDAO();
        championDAO.setChampionId(championId);
        championDAO.setChampionName(championName);

        championRepositoryJPA.save(championDAO);
    }
}
