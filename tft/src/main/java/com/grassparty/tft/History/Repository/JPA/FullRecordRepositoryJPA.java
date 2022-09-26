package com.grassparty.tft.History.Repository.JPA;

import com.grassparty.tft.Model.DB.FullRecordDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FullRecordRepositoryJPA extends JpaRepository<FullRecordDB, String> {

}
