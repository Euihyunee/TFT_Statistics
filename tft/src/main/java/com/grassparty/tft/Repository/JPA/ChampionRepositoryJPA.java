package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DAO.ChampionDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionRepositoryJPA extends JpaRepository<ChampionDAO, String> {
    ChampionDAO findByChampionName(String championName);
}
