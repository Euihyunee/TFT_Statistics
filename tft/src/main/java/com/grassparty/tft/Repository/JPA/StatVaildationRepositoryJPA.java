package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DB.StatValidationTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StatVaildationRepositoryJPA extends JpaRepository<StatValidationTable, String> {

    List<StatValidationTable> findAllByValid(boolean valid);
}
