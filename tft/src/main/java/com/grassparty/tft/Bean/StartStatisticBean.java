package com.grassparty.tft.Bean;

import com.grassparty.tft.Bean.Small.*;
import com.grassparty.tft.Model.DAO.StatDeckDAO;
import com.grassparty.tft.Model.DAO.VersionChampionIndexDAO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Repository.JPA.VersionChampionIndexRepositoryJPA;
import com.grassparty.tft.Repository.JPA.VersionRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class StartStatisticBean {
    @Autowired
    GetRecordBean getRecordBean;
    @Autowired
    GetMatchIdFromStatValidBean getMatchIdFromStatValidBean;
    @Autowired
    MappingChampionIndexBean mappingChampionIndexBean;
    @Autowired
    VersionChampionIndexRepositoryJPA indexRepository;
    @Autowired
    VersionRepositoryJPA repository;
    @Autowired
    GetChampionIdMapBean getChampionIdMapBean;
    @Autowired
    GetParserBean getParserBean;
    @Autowired
    MapIndexToStatDeckBean mapIndexToStatDeckBean;
    @Autowired
    GetVersionIdBean getVersionIdBean;
    @Autowired
    SaveStatDeckBean saveStatDeckBean;
    @Autowired
    MapStatIndexBean mapStatIndexBean;
    @Autowired
    SaveAllStatDeckBean saveAllStatDeckBean;
    @Autowired
    GetSeasonVersionBean getSeasonVersionBean;
    @Autowired
    GetDeckListBean getDeckListBean;

    public void exec(){
        // TODO  밸리데이션 테이블에서 matchId 가져옴
        MatchID matchID = getMatchIdFromStatValidBean.exec();

        // TODO matchid로 Record가져오기
        List<RecordDTO> records = getRecordBean.exec(matchID);


        // record를 1매치당 8개의 덱으로 분해 / 10개 기준으로 80개 덱데이터
        List<StatDeckDAO> deckList = getDeckListBean.exec(records);
        for(StatDeckDAO deck : deckList){
            System.out.println(deck);
        }

        // 데이터 베이스 stat_deck 에 덱 저장
        saveAllStatDeckBean.exec(deckList);

    }
}
