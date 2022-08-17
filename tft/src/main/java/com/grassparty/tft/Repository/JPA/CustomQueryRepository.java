package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DB.*;
import com.grassparty.tft.Service.StatService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomQueryRepository extends JpaRepository<StatServiceTable, Integer> {


//    @Query(value ="")
//    List<StatServiceInterface> GetQuery();
}
