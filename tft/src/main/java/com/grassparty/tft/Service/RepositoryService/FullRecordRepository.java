package com.grassparty.tft.Service.RepositoryService;

import com.grassparty.tft.Model.domain.FullRecordDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FullRecordRepository extends JpaRepository<FullRecordDB, Long> {
}