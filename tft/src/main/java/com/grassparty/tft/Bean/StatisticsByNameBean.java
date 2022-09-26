package com.grassparty.tft.Bean;

import com.grassparty.tft.History.Service.SummonerService;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class StatisticsByNameBean {

    // Service Autowired하면 안 됨
    @Autowired
    SummonerService summonerService;

    public String exec(String name){
        // 이름을 받아서 puuid 얻음
        SummonerDTO summonerDTO = summonerService.GetSummonerDTOByName(name);

        return summonerDTO.getPuuid();
    }
}
