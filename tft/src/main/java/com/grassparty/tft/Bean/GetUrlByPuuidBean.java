package com.grassparty.tft.Bean;

import org.springframework.beans.factory.annotation.Value;

public class GetUrlByPuuidBean {
    @Value("${api_key}")
    private static String api_key;

    public static String exec(String puuid){
        String api_query = "&api_key=";
        String site = "https://asia.api.riotgames.com/tft/match/v1/matches/by-puuid/";
        String site_query = "/ids?start=0&count=10";
        String url = site + puuid + site_query + api_query + api_key;
        return url;
    }
}
