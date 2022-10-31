package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Repository.JPA.StatVaildationRepositoryJPA;
import com.grassparty.tft.Model.DAO.StatValidRecordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertStatVaildationBean {

    @Autowired
    StatVaildationRepositoryJPA statVaildationRepositoryJPA;

    public void exec(String matchId){
        StatValidRecordDAO statValidRecordDAO = StatValidRecordDAO.builder()
                .matchID(matchId)
                .valid(false)
                .build();
        statVaildationRepositoryJPA.save(statValidRecordDAO);
    }
}
