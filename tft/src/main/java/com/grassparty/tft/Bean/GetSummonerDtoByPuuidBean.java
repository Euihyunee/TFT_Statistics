package com.grassparty.tft.Bean;

import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.beans.factory.annotation.Value;

public class GetSummonerDtoByPuuidBean {

    @Value("${api_key}")
    private static String api_key;

    public static String exec(String puuid){
        String api_query = "?api_key=";
        String site = "https://kr.api.riotgames.com/tft/summoner/v1/summoners/by-puuid/";
        String encodedUrl = site + puuid + api_query + api_key;
        return encodedUrl;
    }
}
