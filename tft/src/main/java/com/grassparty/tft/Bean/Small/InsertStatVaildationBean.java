package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Repository.JPA.StatVaildationRepositoryJPA;
import com.grassparty.tft.Model.DB.StatValidationTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertStatVaildationBean {

    @Autowired
    StatVaildationRepositoryJPA statVaildationRepositoryJPA;

    public void exec(String matchId){
        StatValidationTable statValidationTable = StatValidationTable.builder()
                .matchID(matchId)
                .valid(false)
                .build();
        statVaildationRepositoryJPA.save(statValidationTable);
    }
}
