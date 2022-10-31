package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DAO.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomQueryRepository extends JpaRepository<StatDeckSimilarityDAO, Integer> {


//    @Query(value ="")
//    List<StatServiceInterface> GetQuery();
}
