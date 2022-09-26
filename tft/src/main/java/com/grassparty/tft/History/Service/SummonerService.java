package com.grassparty.tft.History.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Service
public class SummonerService {
    @Value("${api_key}")
    private String api_key;


    public SummonerDTO GetSummonerDtoByPuuid(String puuid){
        String api_query = "?api_key=";
        String site = "https://kr.api.riotgames.com/tft/summoner/v1/summoners/by-puuid/";
        String encodedUrl = site + puuid + api_query + api_key;
        return getSummonerDTO(encodedUrl);
    }


    public SummonerDTO GetSummonerDTOByName(String name){
        String encodedName = GetEncode(name);
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
        byte[] stringBytes = name.getBytes();
        String EncondedString = new String(stringBytes, StandardCharsets.UTF_8);
        return EncondedString;
    }
}
