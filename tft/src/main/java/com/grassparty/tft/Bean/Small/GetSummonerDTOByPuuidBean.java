package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class GetSummonerDTOByPuuidBean {

    @Autowired
    GetSummonerDTOBean getSummonerDTOBean;

    @Autowired
    private Environment env;

    public SummonerDTO exec(String puuid){
        String api_query = "?api_key=";
        String site = "https://kr.api.riotgames.com/tft/summoner/v1/summoners/by-puuid/";
        String encodedUrl = site + puuid + api_query + env.getProperty("api_key");
        return getSummonerDTOBean.exec(encodedUrl);
    }
}
