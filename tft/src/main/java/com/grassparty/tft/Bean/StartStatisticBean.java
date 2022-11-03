package com.grassparty.tft.Bean;

import com.grassparty.tft.Bean.Small.GetMatchIdFromStatValidBean;
import com.grassparty.tft.Bean.Small.GetRecordBean;
import com.grassparty.tft.Bean.Small.MakeVersionChampionIndexBean;
import com.grassparty.tft.Model.DAO.VersionChampionIndexDAO;
import com.grassparty.tft.Model.DAO.VersionDAO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Repository.JPA.VersionChampionIndexRepositoryJPA;
import com.grassparty.tft.Repository.JPA.VersionRepositoryJPA;
import com.grassparty.tft.Repository.VersionChampionIndexRepository;
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
    MakeVersionChampionIndexBean makeVersionChampionIndexBean;
    @Autowired
    VersionChampionIndexRepositoryJPA indexRepository;
    @Autowired
    VersionRepositoryJPA repository;

    public void exec(){
        // TODO 밸리데이션 테이블에서 matchId 가져옴
        MatchID matchID = getMatchIdFromStatValidBean.exec();

        // TODO matchid로 Record가져오기
        List<RecordDTO> records = getRecordBean.exec(matchID);

        // TODO record에 있는 version으로 version champion index 가져오기
        // 레코드별 게임 버전가져오기
        // 파싱
        List<String> recordVersionMap = new ArrayList<>();
        for (RecordDTO record: records) {
            String[] version = record.getGame_version().split("\\.");
            recordVersionMap.add(version[0]);
        }

        System.out.println("레코드별 게임 버전가져오기 : " + recordVersionMap);

        // 유니크한 버전 만들기
        List<String> uniqueVersion = new ArrayList<>();
        for (String version: recordVersionMap) {
            if(!uniqueVersion.contains(version)){
                uniqueVersion.add(version);
            }
        }

        System.out.println("유니크한 버전 만들기 : " + uniqueVersion);

        // 버전 챔피언 인덱스 존재 여부 확인
        for(String version: uniqueVersion) {
            int versionInt = Integer.parseInt( version);
            if(!repository.existsBySeasonVersion(versionInt)){
                makeVersionChampionIndexBean.exec(version);
            }
        }



        // 버전 정보별 챔피언 지문 인덱스 가져오기
        // 버전 - 인덱스
        HashMap<Long, VersionChampionIndexDAO> versionMap = new HashMap<>();

        // 버전을 우선 조회하기
        for(String version: uniqueVersion){
            int versionInt = Integer.parseInt( version);
            // 버전 아이디
            Long versionId = repository.findIdBySeasonVersion(versionInt);

            // 조회된 버전 아이디로 지문 조회
            versionMap.put(versionId, indexRepository.findByVersionId(versionId));

        }
        System.out.println("버전맵핑 정보 : " + versionMap);





        // TODO index로 지문 생성

        // TODO deck에 저장


    }
}
