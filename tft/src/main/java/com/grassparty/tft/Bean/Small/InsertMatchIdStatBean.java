package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Repository.RecordRepository;
import com.grassparty.tft.Repository.JPA.RecordRepositoryJPA;
import com.grassparty.tft.Repository.JPA.StatVaildationRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertMatchIdStatBean {
    @Autowired
    RecordRepositoryJPA recordRepositoryJPA;
    @Autowired
    RecordRepository recordRepository;
    @Autowired
    StatVaildationRepositoryJPA statVaildationRepositoryJPA;
    @Autowired
    GetRecordFromMatchDTOBean getRecordFromMatchDTOBean;
    @Autowired
    GetMatchDTOBean getMatchDTOBean;
    @Autowired
    InsertStatVaildRecordBean insertStatVaildRecordBean;
    @Autowired
    SaveRecordBean saveRecordBean;

    public void exec(String matchId){
        // TODO matchid 에 대한 매치 정보가 DB에 이미 있나용?
        boolean isMatchIdExist = recordRepositoryJPA.existsById(matchId);

        // TODO 없음 -> 라이엇에 데이터 요청 -> 데이터 저장, 통계로직에 들어갈 정보 테이블에도 저장
        if(!isMatchIdExist){
            // 라이엇에서 recordDTO받아오기
            saveRecordBean.exec(
                    getRecordFromMatchDTOBean.exec(getMatchDTOBean.exec(matchId))
            );
        }
        // 통계로직용 밸리데이션 테이블 저장
        insertStatVaildRecordBean.exec(matchId);

    }

    public void exec(MatchID matchId){
        for (String mid : matchId.getMatchid()) {
            System.out.println("실행 : " + mid );
            exec(mid);
        }
    }

}
