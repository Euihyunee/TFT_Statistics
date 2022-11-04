package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DAO.VersionDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepositoryJPA extends JpaRepository<VersionDAO, String> {
    boolean existsByTotalVersion(String totalVersion);
    VersionDAO findBySeasonVersion(int seasonVersion);
    VersionDAO findByTotalVersion(String totalVersion);
    boolean existsBySeasonVersion(int seasonVersion);
}
