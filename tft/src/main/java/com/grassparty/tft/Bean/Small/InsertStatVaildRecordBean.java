package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Repository.JPA.StatVaildationRepositoryJPA;
import com.grassparty.tft.Model.DAO.StatValidRecordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertStatVaildRecordBean {

    @Autowired
    StatVaildationRepositoryJPA statVaildationRepositoryJPA;

    public void exec(String matchId){
        // 만약 기존에 저장된 데이터면 스킵
        if(statVaildationRepositoryJPA.existsById(matchId)){
            System.out.println("기존에 저장된 MatchId : " + matchId);
            return;
        }

        StatValidRecordDAO statValidRecordDAO = StatValidRecordDAO.builder()
                .matchID(matchId)
                .valid(false)
                .build();
        statVaildationRepositoryJPA.save(statValidRecordDAO);
    }
}
