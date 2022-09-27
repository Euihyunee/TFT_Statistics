package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Bean.GetMatchIDBean;
import com.grassparty.tft.Model.Riot.MatchID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatisticsByPuuidBean {

    @Autowired
    GetMatchIDBean getMatchIDBean;

    public void exec(String puuid) {
        MatchID matchID = getMatchIDBean.exec(puuid);
        StatisticsByMatchIdBean statisticsByMatchIdBean = new StatisticsByMatchIdBean();
        // matchID로 통계돌리기
        for (String id : matchID.getMatchid()) {
            // return 구간에 함수 호출 때문에 분리 못시키는 중
            statisticsByMatchIdBean.exec(id);

        }
    }
}
