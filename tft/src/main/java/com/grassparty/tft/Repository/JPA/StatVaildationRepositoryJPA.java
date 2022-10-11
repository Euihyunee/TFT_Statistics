package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DAO.StatValidationDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StatVaildationRepositoryJPA extends JpaRepository<StatValidationDAO, String> {

    List<StatValidationDAO> findAllByValid(boolean valid);
}
