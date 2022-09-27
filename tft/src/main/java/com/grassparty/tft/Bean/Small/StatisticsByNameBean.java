package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.stereotype.Component;

@Component
public class StatisticsByNameBean {
    GetSummonerDTOByNameBean GetSummonerDTOByNameBean = new GetSummonerDTOByNameBean();

    public String exec(String name){
        // 이름을 받아서 puuid 얻음
        SummonerDTO summonerDTO = GetSummonerDTOByNameBean.exec(name);

        return summonerDTO.getPuuid();
    }
}
