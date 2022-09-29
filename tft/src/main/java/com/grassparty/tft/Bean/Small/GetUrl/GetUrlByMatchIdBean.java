package com.grassparty.tft.Bean.Small.GetUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class GetUrlByMatchIdBean implements GetUrl{
    @Autowired
    private Environment env;

    public String exec(String matchid){
        String api_query = "?api_key=";
        String site = "https://asia.api.riotgames.com/tft/match/v1/matches/";
        String url = site + matchid + api_query + env.getProperty("api_key");
        return url;
    }
}
