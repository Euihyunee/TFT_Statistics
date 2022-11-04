package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.StatDeckDAO;
import com.grassparty.tft.Repository.JPA.StatRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveStatDeckBean {
    @Autowired
    StatRepositoryJPA repository;
    public void exec(StatDeckDAO dao){
        repository.save(dao);
    }
}
