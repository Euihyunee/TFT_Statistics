package com.grassparty.tft.Repository;

import com.grassparty.tft.Model.DAO.VersionDAO;
import com.grassparty.tft.Repository.JPA.VersionChampionIndexRepositoryJPA;
import com.grassparty.tft.Repository.JPA.VersionRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VersionRepository {
    @Autowired
    VersionRepositoryJPA versionRepositoryJPA;


}
