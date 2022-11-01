package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Repository.RecordRepository;
import com.grassparty.tft.Repository.JPA.FullRecordRepositoryJPA;
import com.grassparty.tft.Repository.JPA.StatVaildationRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatisticsByMatchIdBean {
    @Autowired
    FullRecordRepositoryJPA fullRecordRepositoryJPA;
    @Autowired
    RecordRepository recordRepository;
    @Autowired
    StatVaildationRepositoryJPA statVaildationRepositoryJPA;
    @Autowired
    GetFullRecordFromMatchDTOBean getFullRecordFromMatchDTOBean;
    @Autowired
    GetMatchDTOBean getMatchDTOBean;

    public void exec(String matchId){
//        // 밸리데이션 체크
//        InsertStatVaildation(matchId);

        // 기존에 데이터 저장되어있는지 체크
        boolean isMatchIdExist =
                fullRecordRepositoryJPA.existsById(matchId);
        if(!isMatchIdExist){
            // fullrecordDTO받아오기
            recordRepository.InsertFullRecord(
                    getFullRecordFromMatchDTOBean.exec(getMatchDTOBean.exec(matchId))
            );
        }
    }
//    public void InsertStatVaildation(String matchId){
//        StatValidationTable statValidationTable = StatValidationTable.builder()
//                .matchID(matchId)
//                .valid(false)
//                .build();
//        statVaildationRepositoryJPA.save(statValidationTable);
//    }
}
