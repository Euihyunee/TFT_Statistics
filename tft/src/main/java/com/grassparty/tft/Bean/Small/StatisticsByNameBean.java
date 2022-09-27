package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatisticsByNameBean {

    @Autowired
    GetSummonerDTOByNameBean GetSummonerDTOByNameBean;

    public String exec(String name){
        // 이름을 받아서 puuid 얻음
        SummonerDTO summonerDTO = GetSummonerDTOByNameBean.exec(name);

        return summonerDTO.getPuuid();
    }
}
