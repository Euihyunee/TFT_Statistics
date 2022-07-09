package com.grassparty.tft.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

// api_key RGAPI-60a5827e-8baf-453c-b7b8-13ac51ca7d61

// 의현 : RGAPI-60eb9a0a-89d3-472f-aacc-67af1dbcdfd1

@Service
public class SummonerService {
    private String api_key = "RGAPI-1374a973-0f55-4f62-bff4-a39218465c23";


    public SummonerDTO GetSummonerDtoByPuuid(String puuid){
        String api_query = "?api_key=";
        String site = "https://kr.api.riotgames.com/tft/summoner/v1/summoners/by-puuid/";
        String encodedUrl = site + puuid + api_query + api_key;
        return getSummonerDTO(encodedUrl);
    }


    public SummonerDTO GetSummonerDTOByName(String name){
        String encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8);
        String api_query = "?api_key=";
        String site = "https://kr.api.riotgames.com/tft/summoner/v1/summoners/by-name/";
        String encodedUrl = site + encodedName + api_query + api_key;
        return getSummonerDTO(encodedUrl);
    }


    private SummonerDTO getSummonerDTO(String encodedUrl) {
        URL url;
        SummonerDTO summonerDTO = null;
        try {
            url = new URL(encodedUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            InputStream responseStream = con.getInputStream();

            // Manually converting the response body InputStream to summonerDTO using Jackson
            ObjectMapper mapper = new ObjectMapper();
            summonerDTO = mapper.readValue(responseStream, SummonerDTO.class);
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return summonerDTO;
    }

    public String GetEncode(String name){
        return URLEncoder.encode(name, StandardCharsets.UTF_8);
    }
}
