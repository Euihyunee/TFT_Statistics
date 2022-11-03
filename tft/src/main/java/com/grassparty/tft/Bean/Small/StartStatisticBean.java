package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.Riot.MatchID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartStatisticBean {
    @Autowired
    GetRecordBean getRecordBean;
    @Autowired
    GetMatchIdFromStatValidBean getMatchIdFromStatValidBean;

    public void exec(){
        // TODO 밸리데이션 테이블에서 matchId 가져옴
        MatchID matchID = getMatchIdFromStatValidBean.exec();

        // TODO matchid로 Record가져오기
        getRecordBean.exec(matchID);

        // TODO record에 있는 version으로 version champion index 가져오기

        // TODO index로 지문 생성

        // TODO deck에 저장


    }
}
