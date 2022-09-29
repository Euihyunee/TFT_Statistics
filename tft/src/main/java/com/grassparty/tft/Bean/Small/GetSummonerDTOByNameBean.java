package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@EnableConfigurationProperties
public class GetSummonerDTOByNameBean {

    @Autowired
    GetEncodeBean getEncodeBean;
    @Autowired
    GetSummonerDTOBean getSummonerDTOBean;
    @Autowired
    private Environment env;

    public SummonerDTO exec(String name){
        String encodedName = getEncodeBean.exec(name);

        String api_query = "?api_key=";
        String site = "https://kr.api.riotgames.com/tft/summoner/v1/summoners/by-name/";
        String encodedUrl = site + encodedName + api_query + env.getProperty("api_key");
        return getSummonerDTOBean.exec(encodedUrl);
    }
}
