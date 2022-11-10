package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DAO.StatChampionDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatChampionRepositoryJPA extends JpaRepository<StatChampionDAO, Long> {
    StatChampionDAO findByChampionName(String championName);
    boolean existsByChampionName(String championName);
    List<StatChampionDAO> findAll();
}
