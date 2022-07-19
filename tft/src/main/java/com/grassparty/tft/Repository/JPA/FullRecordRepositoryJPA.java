package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DB.FullRecordDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FullRecordRepositoryJPA extends JpaRepository<FullRecordDB, String> {
}
