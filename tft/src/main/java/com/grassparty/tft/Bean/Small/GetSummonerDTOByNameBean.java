package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GetSummonerDTOByNameBean {

    @Autowired
    GetEncodeBean getEncodeBean;

    @Value("${api_key}")
    private static String api_key;

    public SummonerDTO exec(String name){
        String encodedName = getEncodeBean.exec(name);

        GetSummonerDTOBean getSummonerDTOBean = new GetSummonerDTOBean();

        String api_query = "?api_key=";
        String site = "https://kr.api.riotgames.com/tft/summoner/v1/summoners/by-name/";
        String encodedUrl = site + encodedName + api_query + api_key;
        return getSummonerDTOBean.exec(encodedUrl);
    }
}
