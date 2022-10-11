package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DAO.FullRecordDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FullRecordRepositoryJPA extends JpaRepository<FullRecordDAO, String> {

}
