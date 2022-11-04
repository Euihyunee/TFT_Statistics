package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DAO.StatChampionDeckCountDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatChampionDeckCountRepositoryJPA extends JpaRepository<StatChampionDeckCountDAO, Long> {

    Boolean existsByVersionId(Long versionId);
    StatChampionDeckCountDAO findByVersionId(Long versionId);
}
