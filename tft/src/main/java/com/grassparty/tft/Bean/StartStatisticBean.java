package com.grassparty.tft.Bean;

import com.grassparty.tft.Bean.Small.*;
import com.grassparty.tft.Model.DAO.StatDeckDAO;
import com.grassparty.tft.Model.DAO.VersionChampionIndexDAO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Repository.JPA.StatRepositoryJPA;
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
    GetChampionIdListBean getChampionIdListBean;
    @Autowired
    GetParserBean getParserBean;
    @Autowired
    MapIndexToStatDeckBean mapIndexToStatDeckBean;
    @Autowired
    GetVersionIdBean getVersionIdBean;
    @Autowired
    SaveStatDeckBean saveStatDeckBean;

    public void exec(){
        // TODO  밸리데이션 테이블에서 matchId 가져옴
        MatchID matchID = getMatchIdFromStatValidBean.exec();

        // TODO matchid로 Record가져오기
        List<RecordDTO> records = getRecordBean.exec(matchID);

        // TODO record에 있는 version으로 version champion index 가져오기
        // 레코드별 게임 버전가져오기
        // 파싱
        List<Integer> recordVersionMap = new ArrayList<>();
        for (RecordDTO record: records) {
            int version = getParserBean.exec(record.getGame_version(), GetParserBean.EnumVersion.Season);
            recordVersionMap.add(version);
        }

        System.out.println("레코드별 게임 버전가져오기 : " + recordVersionMap);

        // 유니크한 버전 만들기
        List<Integer> uniqueVersion = new ArrayList<>();
        for (int version: recordVersionMap) {
            if(!uniqueVersion.contains(version)){
                uniqueVersion.add(version);
            }
        }
        System.out.println("유니크한 버전 만들기 : " + uniqueVersion);

        // 버전 정보별 챔피언 지문 인덱스 가져오기
        // 버전 - 인덱스
        HashMap<Integer, List<VersionChampionIndexDAO>> versionMap = new HashMap<>();

        // 버전을 우선 조회하기
        for(int version: uniqueVersion){

            if(!indexRepository.existsBySeasonVersion(version)){
                System.out.println("seasonVersion 존재하지 않음 : " + version);
                break;
            }
            // 조회된 버전 아이디로 지문 조회 후 저장
            versionMap.put(version, indexRepository.findAllBySeasonVersion(version));
        }

        // TODO index로 지문 생성

        for (RecordDTO record: records){
            // 결과를 넣을곳
            StatDeckDAO statDeckDAO = new StatDeckDAO();

            // 챔피언 아이디 리스트
            List<String> championIdList = getChampionIdListBean.exec(record);

            // 챔피언 아이디의 인덱스를 찾음 (레코드 버전과 챔피언아이디로)
            int version = getParserBean.exec(record.getGame_version(), GetParserBean.EnumVersion.Season);

            // 레코드 버전으로 버전 id 가져오기
            long versionId = getVersionIdBean.exec(record.getGame_version());
            statDeckDAO.setVersionId(versionId);

            for(VersionChampionIndexDAO indexDAO: versionMap.get(version)){
                for(String championId:championIdList){
                    if(championId.equals(indexDAO.getChampionId())){
                        statDeckDAO = mapIndexToStatDeckBean.exec(statDeckDAO, indexDAO.getOrderIndex());
                    }
                }
            }

            // TODO deck에 저장
            saveStatDeckBean.exec(statDeckDAO);
        }



    }
}
