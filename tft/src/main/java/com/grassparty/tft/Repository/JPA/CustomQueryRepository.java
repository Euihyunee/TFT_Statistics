package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DB.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomQueryRepository extends JpaRepository<StatServiceTable, Integer> {


//    @Query(value ="")
//    List<StatServiceInterface> GetQuery();
}
