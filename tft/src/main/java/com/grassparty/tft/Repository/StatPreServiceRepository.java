package com.grassparty.tft.Repository;

import com.grassparty.tft.Model.DAO.StatPreServiceDAO;
import com.grassparty.tft.Repository.JPA.CustomPreQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatPreServiceRepository {
    @Autowired
    CustomPreQueryRepository statPreServiceRepositoryJPA;

    public StatPreServiceDAO testPrintCount(){
        StatPreServiceDAO statPreServiceTable;

        statPreServiceTable = statPreServiceRepositoryJPA.getMaxCountRow();

        return statPreServiceTable;

    }
}
