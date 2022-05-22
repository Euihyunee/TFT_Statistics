package com.grassparty.tft.Service;

// 병그니 "puuid": "B4ih79LiSu71XEqrD9RyY9RZK5PG5y495cRv9lmGx0emFsYYx32ftAKARxcQ7p4IQM_z-t_pt5qVKA" "counts=q?"
// matchid : "KR_5927958808"

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grassparty.tft.Model.Riot.MatchDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Service
public class MatchDTOService {

//    public MatchId GetMatchIdByPuuid(String puuid){
//        String api_query = "?api_key=";
//        String api_key = "RGAPI-60eb9a0a-89d3-472f-aacc-67af1dbcdfd1";
//        String site = "https://asia.api.riotgames.com/tft/match/v1/matches/by-puuid/";
//        String site_query = "ids?start=0&count=1";
//        String url = site + puuid + site_query + api_query + api_key;
//    }
    public MatchDTO GetMatchDTOByMatchId(String matchid){
        String api_query = "?api_key=";
        String api_key = "RGAPI-14b9bb7b-1eb9-4903-94f7-4dc8a0e6c033";
        String site = "https://asia.api.riotgames.com/tft/match/v1/matches/";
        String url = site + matchid + api_query + api_key;
        return GetMatchDTO(url);
    }
    private MatchDTO GetMatchDTO(String url){
        URL url1;
        MatchDTO matchDTO = null;
        try {
            url1 = new URL(url);
            HttpURLConnection con = (HttpURLConnection) url1.openConnection();
            con.setRequestMethod("GET");
            InputStream responseStream = con.getInputStream();

            // Manually converting the response body InputStream to summonerDTO using Jackson
            ObjectMapper mapper = new ObjectMapper();
            matchDTO = mapper.readValue(responseStream, MatchDTO.class);

        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return matchDTO;
    }
}
