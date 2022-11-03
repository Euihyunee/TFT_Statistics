package com.grassparty.tft.Repository;

import com.grassparty.tft.Repository.JPA.VersionChampionIndexRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VersionChampionIndexRepository {
    @Autowired
    VersionChampionIndexRepositoryJPA versionChampionIndexRepositoryJPA;


}
