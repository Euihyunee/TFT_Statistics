package com.grassparty.tft.History.Repository.JPA;

import com.grassparty.tft.Model.DB.StatTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatRepositoryJPA extends JpaRepository<StatTable, Integer> {
}
