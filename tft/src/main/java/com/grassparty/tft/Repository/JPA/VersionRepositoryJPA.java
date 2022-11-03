package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DAO.VersionChampionIndexDAO;
import com.grassparty.tft.Model.DAO.VersionDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import java.util.Optional;

public interface VersionRepositoryJPA extends JpaRepository<VersionDAO, String> {
    Long findIdBySeasonVersion(String seasonVersion);
    boolean existsBySeasonVersion(String seasonVersion);
}
