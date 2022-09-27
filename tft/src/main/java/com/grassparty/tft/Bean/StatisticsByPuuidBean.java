package com.grassparty.tft.Bean;

import com.grassparty.tft.Model.Riot.MatchID;

public class StatisticsByPuuidBean {

    public void exec(String puuid) {
        GetMatchIDBean getMatchIDBean = new GetMatchIDBean();
        MatchID matchID = getMatchIDBean.exec(puuid);
        StatisticsByMatchIdBean statisticsByMatchIdBean = new StatisticsByMatchIdBean();
        // matchID로 통계돌리기
        for (String id : matchID.getMatchid()) {
            // return 구간에 함수 호출 때문에 분리 못시키는 중
            statisticsByMatchIdBean.exec(id);

        }
    }
}
