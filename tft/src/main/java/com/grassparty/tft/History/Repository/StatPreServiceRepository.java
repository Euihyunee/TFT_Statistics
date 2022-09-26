package com.grassparty.tft.History.Repository;

import com.grassparty.tft.Model.DB.StatPreServiceTable;
import com.grassparty.tft.History.Repository.JPA.CustomPreQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatPreServiceRepository {
    @Autowired
    CustomPreQueryRepository statPreServiceRepositoryJPA;

    public StatPreServiceTable testPrintCount(){
        StatPreServiceTable statPreServiceTable;

        statPreServiceTable = statPreServiceRepositoryJPA.getMaxCountRow();

        return statPreServiceTable;

    }
}
