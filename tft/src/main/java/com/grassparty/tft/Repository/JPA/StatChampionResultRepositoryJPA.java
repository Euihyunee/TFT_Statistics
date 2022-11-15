package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DAO.StatChampionResultDAO;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatChampionResultRepositoryJPA extends JpaRepository<StatChampionResultDAO, Long> {

    List<StatChampionResultDAO> findAll();

    Boolean existsByChampionIdAndAndChampionId(Long versionId, String championName);

    StatChampionResultDAO findByVersionIdAndChampionId(Long versionId, String championName);
}
