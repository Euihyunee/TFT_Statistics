package com.grassparty.tft.History.Service;

// 병그니 "puuid": "B4ih79LiSu71XEqrD9RyY9RZK5PG5y495cRv9lmGx0emFsYYx32ftAKARxcQ7p4IQM_z-t_pt5qVKA" "counts=q?"
// matchid : "KR_5927958808"

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grassparty.tft.Bean.*;
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

    // 1개
    public MatchDto GetMatchDTOByMatchId(String matchid) {
        GetUrlByMatchIdBean GetUrlByMatchIdBean = new GetUrlByMatchIdBean();
        GetMatchDTOBean GetMatchDTOBean = new GetMatchDTOBean();

        return GetMatchDTOBean.exec(GetUrlByMatchIdBean.exec(matchid));
    }

    // 여러개
    public MatchDtos GetMatchDTOByMatchIds(MatchID matchids) {
        GetMatchDTOByMatchIdsBean GetMatchDTOByMatchIdsBean = new GetMatchDTOByMatchIdsBean();

        return GetMatchDTOByMatchIdsBean.exec(matchids);
    }

    private MatchDto GetMatchDTO(String matchid){
        GetMatchDTOBean GetMatchDTOBean = new GetMatchDTOBean();

        return GetMatchDTOBean.exec(matchid);
    }
}