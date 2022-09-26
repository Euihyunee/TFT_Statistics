package com.grassparty.tft.Bean;

import com.grassparty.tft.History.Service.MatchDTOService;
import com.grassparty.tft.Model.Riot.MatchID;
import org.springframework.beans.factory.annotation.Autowired;

public class StatisticsByPuuidBean {

    @Autowired
    MatchDTOService matchservice;

    public void exec(String puuid) {
        // matchID 받아오기
        MatchID matchID = matchservice.GetMatchIdByPuuid(puuid);

        // matchID로 통계돌리기
        for (String id : matchID.getMatchid()) {
            // return 구간에 함수 호출 때문에 분리 못시키는 중
            StatisticsByMatchId(id);

        }
    }
}
