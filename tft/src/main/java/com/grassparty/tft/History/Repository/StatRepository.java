package com.grassparty.tft.History.Repository;

import com.grassparty.tft.History.Repository.JPA.StatRepositoryJPA;
import com.grassparty.tft.Model.DB.StatTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatRepository {
    @Autowired
    StatRepositoryJPA statRepositoryJPA;

    public void save(StatTable statTable){
        statRepositoryJPA.save(statTable);
    }



}
