package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.StatDeckDAO;
import com.grassparty.tft.Model.DAO.VersionChampionIndexDAO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Repository.JPA.VersionChampionIndexRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class GetDeckListBean {
    @Autowired
    GetSeasonVersionBean getSeasonVersionBean;
    @Autowired
    VersionChampionIndexRepositoryJPA indexRepository;
    @Autowired
    GetParserBean getParserBean;
    @Autowired
    GetChampionIdListBean getChampionIdListBean;
    @Autowired
    GetChampionIdMapBean getChampionIdMapBean;
    @Autowired
    MapIndexToStatDeckBean mapIndexToStatDeckBean;

    // 덱이 여러개 들어올때
    public List<StatDeckDAO> exec(List<RecordDTO> records){
        List<StatDeckDAO> decklist = new ArrayList<>();
        for(RecordDTO record : records){
            for(StatDeckDAO deck : exec(record)){
                decklist.add(deck);
            }
        }
        return decklist;
    }
    // 덱이 한개만 들어올때
    public List<StatDeckDAO> exec(RecordDTO record){
        List<StatDeckDAO> decklist = new ArrayList<>();

        int seasonVersion = getSeasonVersionBean.exec(record);
        long versionId = getParserBean.exec(record.getGame_version(), GetParserBean.EnumVersion.Season);
        List<VersionChampionIndexDAO> championIndex = indexRepository.findAllBySeasonVersion(seasonVersion);


        for(int i=0;i<8; i++){
            StatDeckDAO deck = new StatDeckDAO();
            deck.setVersionId(versionId);

            List<String> championIdList = getChampionIdListBean.exec(record);

            for(String championId : championIdList){
                int index = 0;
                for(VersionChampionIndexDAO indexDAO: championIndex){
                    if(championId.equals(indexDAO.getChampionId())){
                        index = indexDAO.getOrderIndex();
                        break;
                    }
                }
                deck = mapIndexToStatDeckBean.exec(deck, index);
            }
            decklist.add(deck);
        }

        return decklist;
    }

}
