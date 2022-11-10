package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.ChampionDAO;
import com.grassparty.tft.Repository.JPA.ChampionRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetChampionNameByChampionIdBean {

    @Autowired
    ChampionRepositoryJPA championRepository;

    // RecordDTO에서 champion_name으로 champion 테이블에서 champion_id 가져오기
    public String exec(String championId) {
        ChampionDAO championDAO = championRepository.findByChampionId(championId);
        return championDAO.getChampionId();
}
}
