package com.grassparty.tft.Repository;

import com.grassparty.tft.Repository.JPA.StatRepositoryJPA;
import com.grassparty.tft.Model.DAO.StatDeckDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatRepository {
    @Autowired
    StatRepositoryJPA statRepositoryJPA;

    public void save(StatDeckDAO statDeckDAO){
        statRepositoryJPA.save(statDeckDAO);
    }



}
