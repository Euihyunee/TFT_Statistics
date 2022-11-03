package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Repository.StatValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMatchIdFromStatValidBean {
    @Autowired
    StatValidationRepository repository;

    public MatchID exec(){
        return repository.GetMatchIdFromStatValidation();
    }
}
