package com.grassparty.tft.Bean.Small;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class GetUrlByPuuidBean {
    @Autowired
    private Environment env;

    public String exec(String puuid){
        String site = "https://asia.api.riotgames.com/tft/match/v1/matches/by-puuid/";
        String site_query = "/ids?start=0&count=10";
        String api_query = "&api_key=";
        String url = site + puuid + site_query + api_query + env.getProperty("api_key");
        System.out.println("url 찍음");
        System.out.println(url);
        return url;
    }
}
