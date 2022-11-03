package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.VersionChampionIndexDAO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Repository.JPA.VersionChampionIndexRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MappingChampionIndexBean {
    @Autowired
    GetChampionIdListBean getChampionIdListBean;
    @Autowired
    GetParserBean getParserBean;
    @Autowired
    VersionChampionIndexRepositoryJPA repositoryJPA;

    public void exec(RecordDTO recordDTO){
        // 12.20.448.8884
        // 12 seasonVersion
        int seasonVersion = getParserBean.exec(recordDTO.getGame_version(), GetParserBean.EnumVersion.Season);

        // 챔피언 이름 뽑기
        List<String> chanpionIdList = getChampionIdListBean.exec(recordDTO);
        
        // 챔피언이 저장되어있는지 확인하고
        for (String championId : chanpionIdList) {
            if(repositoryJPA.existsByChampionIdAndSeasonVersion(championId, seasonVersion)){
                continue; // 정보가 저장되어있으면 pass
            }
            // 없으면 저장하는데 버전으로 order_index 가 가장 큰값 찾고
            if(!repositoryJPA.existsBySeasonVersion(seasonVersion)){
                VersionChampionIndexDAO versionChampionIndexDAO = new VersionChampionIndexDAO();
                versionChampionIndexDAO.setChampionId(championId);
                versionChampionIndexDAO.setOrderIndex(1);
                versionChampionIndexDAO.setSeasonVersion(seasonVersion);
                repositoryJPA.save(versionChampionIndexDAO);
                continue;
            }
            VersionChampionIndexDAO versionChampionIndexDAO =  repositoryJPA.findTopBySeasonVersionOrderByOrderIndexDesc(seasonVersion);
            int index = versionChampionIndexDAO.getOrderIndex() + 1;
            VersionChampionIndexDAO insert = new VersionChampionIndexDAO();
            insert.setChampionId(championId);
            insert.setOrderIndex(index);
            insert.setSeasonVersion(seasonVersion);
            repositoryJPA.save(insert);

        }



    }
}

