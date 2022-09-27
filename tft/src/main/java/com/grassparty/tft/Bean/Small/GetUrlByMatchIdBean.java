package com.grassparty.tft.Bean.Small;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GetUrlByMatchIdBean {

    @Value("${api_key}")
    private static String api_key;

    public String exec(String matchid){
        String api_query = "?api_key=";
        String site = "https://asia.api.riotgames.com/tft/match/v1/matches/";
        String url = site + matchid + api_query + api_key;
        return url;
    }
}
