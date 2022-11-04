package com.grassparty.tft.Repository;

import com.grassparty.tft.Repository.JPA.StatChampionDeckCountRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatChampionDeckCountRepository {
    @Autowired
    StatChampionDeckCountRepositoryJPA statChampionDeckCountRepositoryJPA;
}
