package com.grassparty.tft.Service;

// 병그니 "puuid": "B4ih79LiSu71XEqrD9RyY9RZK5PG5y495cRv9lmGx0emFsYYx32ftAKARxcQ7p4IQM_z-t_pt5qVKA" "counts=q?"
// matchid : "KR_5927958808"

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.MatchDtos;
import com.grassparty.tft.Model.Riot.MatchID;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatchDTOService {
    private String api_key = "RGAPI-eb89a560-ec61-4f1e-9cd0-90b30853ef78";

    public MatchID GetMatchIdByPuuid(String puuid){
        String api_query = "&api_key=";
        String site = "https://asia.api.riotgames.com/tft/match/v1/matches/by-puuid/";
        String site_query = "/ids?start=0&count=10";
        String url = site + puuid + site_query + api_query + api_key;
        return GetMatchID(url);
    }

    private MatchID GetMatchID(String matchurl) {
        MatchID matchID = new MatchID();
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("X-Riot-Token", api_key); //헤더에 API키 추가

            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            ResponseEntity<String> response = restTemplate.exchange(matchurl, HttpMethod.GET, entity, String.class); //요청을 보내어 결과를 받아옴

            String matches = response.getBody().toString();
            matches = matches.replace("[", "");
            matches = matches.replace("]", "");
            matches = matches.replace("\"", "");
            String[] matchList = matches.split(",");
            matchID.setMatchid(matchList);
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("GET");

//            InputStream responseStream = con.getInputStream();
//
//            // Manually converting the response body InputStream to summonerDTO using Jackson
//            ObjectMapper mapper = new ObjectMapper();
//            matchID = mapper.readValue(responseStream, MatchID.class);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return matchID;
    }
    // 1개
    public MatchDto GetMatchDTOByMatchId(String matchid) {
        String api_query = "?api_key=";
        String site = "https://asia.api.riotgames.com/tft/match/v1/matches/";
        String url = site + matchid + api_query + api_key;
        return GetMatchDTO(url);
    }
    // 여러개
    public MatchDtos GetMatchDTOByMatchIds(MatchID matchids) {
        String api_query = "?api_key=";
        String site = "https://asia.api.riotgames.com/tft/match/v1/matches/";
        String url;

        // 이거 이상함
        MatchDtos matchDtos = new MatchDtos();
        MatchDto matchDto = new MatchDto();

        // 적제
        for(int i =0; i< matchids.getMatchid().length; i++){
            url = site + matchids.getMatchid()[i] + api_query + api_key;
            matchDto = GetMatchDTO(url);
            matchDtos.PushMatchDto(matchDto);
        }

        return matchDtos;
    }
    @ResponseBody
    private MatchDto GetMatchDTO(String matchurl){
        MatchDto matchDto = null;
        try {
            URL url = new URL(matchurl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            InputStream responseStream = con.getInputStream();

            // Manually converting the response body InputStream to summonerDTO using Jackson
            ObjectMapper mapper = new ObjectMapper();
            matchDto = mapper.readValue(responseStream, MatchDto.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return matchDto;
    }
}