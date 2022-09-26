package com.grassparty.tft.Bean;

import com.grassparty.tft.History.Repository.JPA.StatVaildationRepositoryJPA;
import com.grassparty.tft.Model.DB.StatValidationTable;
import org.springframework.beans.factory.annotation.Autowired;

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
