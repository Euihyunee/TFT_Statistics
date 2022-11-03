package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DAO.RecordDAO;
import com.grassparty.tft.Model.DAO.VersionChampionIndexDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VersionChampionIndexRepositoryJPA extends JpaRepository<VersionChampionIndexDAO, String> {
    VersionChampionIndexDAO findBySeasonVersion(Long seasonVersion);
    boolean existsByChampionIdAndSeasonVersion(String championId, int seasonVersion);
    boolean existsBySeasonVersion(int seasonVersion);
    VersionChampionIndexDAO findTopBySeasonVersionOrderByOrderIndexDesc(int seasonVersion);
}
