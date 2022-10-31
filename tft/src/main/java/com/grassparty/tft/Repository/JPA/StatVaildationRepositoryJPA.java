package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DAO.StatValidRecordDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StatVaildationRepositoryJPA extends JpaRepository<StatValidRecordDAO, String> {

    List<StatValidRecordDAO> findAllByValid(boolean valid);
}
