package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.StatDeckDAO;
import com.grassparty.tft.Model.DAO.VersionChampionIndexDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapStatIndexBean {
    @Autowired
    MapIndexToStatDeckBean mapIndexToStatDeckBean;

    public StatDeckDAO exec(StatDeckDAO statDeckDAO, List<String> championIdList, VersionChampionIndexDAO indexDAO){
        for (String championId : championIdList) {
            System.out.println("챔피언 아이디 : " + championId);
            if (championId.equals(indexDAO.getChampionId())) {
                statDeckDAO = mapIndexToStatDeckBean.exec(statDeckDAO, indexDAO.getOrderIndex());

            }
        }
        return statDeckDAO;
    }
}
