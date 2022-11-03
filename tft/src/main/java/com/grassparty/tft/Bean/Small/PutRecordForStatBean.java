package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PutRecordForStatBean {

    @Autowired
    GetSummonerDTOByNameBean getSummonerDTOByNameBean;

    public String exec(String name){
        // 이름을 받아서 puuid 얻음
        SummonerDTO summonerDTO = getSummonerDTOByNameBean.exec(name);

        // TODO puuid로 최근 매치 20개 가져오깅
        // 근데 더블업이면 어떻게함..

        // TODO matchid 에 대한 매치 정보가 DB에 이미 있나용?

        // TODO 있음 -> 스킵

        // TODO 없음 -> 라이엇에 데이터 요청 -> 데이터 저장

        return summonerDTO.getPuuid();
    }
}
