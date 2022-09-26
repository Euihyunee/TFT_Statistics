package com.grassparty.tft.Bean;

import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.beans.factory.annotation.Value;

import java.nio.charset.StandardCharsets;

public class GetSummonerDTOByNameBean {

    @Value("${api_key}")
    private static String api_key;

    public static String exec(String name){
        String encodedName = GetEncode(name);
        String api_query = "?api_key=";
        String site = "https://kr.api.riotgames.com/tft/summoner/v1/summoners/by-name/";
        String encodedUrl = site + encodedName + api_query + api_key;
        return encodedUrl;
    }
    public static String GetEncode(String name){
        byte[] stringBytes = name.getBytes();
        String EncondedString = new String(stringBytes, StandardCharsets.UTF_8);
        return EncondedString;
    }
}
