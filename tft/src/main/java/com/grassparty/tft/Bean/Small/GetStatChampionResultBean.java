package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.StatChampionResultDAO;
import com.grassparty.tft.Repository.JPA.StatChampionResultRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetStatChampionResultBean {

    @Autowired
    StatChampionResultRepositoryJPA statChampionResultRepositoryJPA;

    public List<StatChampionResultDAO> exec() {
        return statChampionResultRepositoryJPA.findAll();
    }
}
