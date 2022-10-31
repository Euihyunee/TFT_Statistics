package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DAO.RecordDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FullRecordRepositoryJPA extends JpaRepository<RecordDAO, String> {

}
