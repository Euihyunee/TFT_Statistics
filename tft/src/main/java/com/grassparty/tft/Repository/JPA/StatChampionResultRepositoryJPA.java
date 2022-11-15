package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DAO.StatChampionResultDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatChampionResultRepositoryJPA extends JpaRepository<StatChampionResultDAO, Long> {

    List<StatChampionResultDAO> findAll();
}
