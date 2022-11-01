package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DAO.StatDeckGroupDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomPreQueryRepository extends JpaRepository<StatDeckGroupDAO, Integer> {

    @Query(value = "select * from tbl_statpreservice where count = " +
            " (select max(count) from tbl_statpreservice)", nativeQuery = true)
    StatDeckGroupDAO getMaxCountRow();
    //, SUM(placement), COUNT(deck_id)

    @Query(value = "select * from tbl_statpreservice where count = " +
            " (select max(count) from tbl_statpreservice)", nativeQuery = true)
    StatDeckGroupDAO getCountDesc();
}
