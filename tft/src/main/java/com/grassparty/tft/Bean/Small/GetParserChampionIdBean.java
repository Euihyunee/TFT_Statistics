package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.ChampionDAO;
import org.springframework.stereotype.Component;

@Component
public class GetParserChampionIdBean {

    public String exec(String championId){

        String[] ChampionPaser = championId.split("_");
        return ChampionPaser[1];
    }
}
