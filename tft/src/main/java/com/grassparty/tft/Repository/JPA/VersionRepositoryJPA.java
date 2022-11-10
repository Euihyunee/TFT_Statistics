package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DAO.VersionDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepositoryJPA extends JpaRepository<VersionDAO, String> {
    boolean existsByTotalVersion(String totalVersion);
    VersionDAO findByTotalVersion(String totalVersion);
    VersionDAO findBySeasonVersion(int seasonVersion);
    VersionDAO findByVersionId(long versionId);
    boolean existsBySeasonVersion(int seasonVersion);
    VersionDAO findBySeasonVersionAndAndUpdateVersion(int seasonVersion, int updateVersion);
}
