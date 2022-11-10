package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.StatDeckDAO;
import com.grassparty.tft.Repository.JPA.StatRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveAllStatDeckBean {
    @Autowired
    StatRepositoryJPA repository;
    public void exec(List<StatDeckDAO> daoList){
        repository.saveAll(daoList);
    }
}
