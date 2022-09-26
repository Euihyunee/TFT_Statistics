package com.grassparty.tft.History.Service;

// 병그니 "puuid": "B4ih79LiSu71XEqrD9RyY9RZK5PG5y495cRv9lmGx0emFsYYx32ftAKARxcQ7p4IQM_z-t_pt5qVKA" "counts=q?"
// matchid : "KR_5927958808"

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grassparty.tft.Bean.GetMatchIDBean;
import com.grassparty.tft.Bean.GetUrlByPuuidBean;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.MatchDtos;
import com.grassparty.tft.Model.Riot.MatchID;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${api_key}")
    private String api_key;

    public MatchID GetMatchIdByPuuid(String puuid){
        GetUrlByPuuidBean GetUrlByPuuidBean = new GetUrlByPuuidBean();
        GetMatchIDBean GetMatchIDBean = new GetMatchIDBean();
        return GetMatchIDBean.exec(GetUrlByPuuidBean.exec(puuid));
    }

    private MatchID GetMatchID(String puuid) {
        GetMatchIDBean GetMatchIDBean = new GetMatchIDBean();
        return GetMatchIDBean.exec(puuid);
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