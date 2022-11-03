package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PutRecordForStatBean {

    @Autowired
    GetSummonerDTOByNameBean getSummonerDTOByNameBean;

    @Autowired
    GetMatchIDBean getMatchIDBean;
    @Autowired
    InsertMatchIdStatBean insertMatchIdStatBean;

    public String exec(String name){
        // 이름을 받아서 puuid 얻음
        SummonerDTO summonerDTO = getSummonerDTOByNameBean.exec(name);

        // TODO puuid로 최근 매치 N개 가져오깅
        // 근데 더블업이면 어떻게함..
        MatchID matchID = getMatchIDBean.exec(summonerDTO);

        // TODO 매치들을 통계가 돌수있게 통계 DB에 저장
        insertMatchIdStatBean.exec(matchID);



        return summonerDTO.getPuuid();
    }
}
