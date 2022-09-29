package com.grassparty.tft.Bean.Small.GetUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class GetUrlByPuuidBean implements GetUrl{
    @Autowired
    private Environment env;

    public String exec(String puuid){
        String site = "https://asia.api.riotgames.com/tft/match/v1/matches/by-puuid/";
        String site_query = "/ids?start=0&count=10";
        String api_query = "&api_key=";
        String url = site + puuid + site_query + api_query + env.getProperty("api_key");
        return url;
    }
}
