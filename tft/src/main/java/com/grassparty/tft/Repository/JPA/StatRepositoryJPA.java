package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DAO.StatDeckDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatRepositoryJPA extends JpaRepository<StatDeckDAO, Integer> {
}
