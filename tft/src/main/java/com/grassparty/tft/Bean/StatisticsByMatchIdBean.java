package com.grassparty.tft.Bean;

import com.grassparty.tft.Repository.FullRecordRepository;
import com.grassparty.tft.Repository.JPA.FullRecordRepositoryJPA;
import com.grassparty.tft.Repository.JPA.StatVaildationRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;

public class StatisticsByMatchIdBean {
    @Autowired
    FullRecordRepositoryJPA fullRecordRepositoryJPA;
    @Autowired
    FullRecordRepository fullRecordRepository;
    @Autowired
    StatVaildationRepositoryJPA statVaildationRepositoryJPA;

    GetFullRecordFromMatchDTOBean GetFullRecordFromMatchDTOBean = new GetFullRecordFromMatchDTOBean();
    GetMatchDTOBean GetMatchDTOBean = new GetMatchDTOBean();


    public void exec(String matchId){
//        // 밸리데이션 체크
//        InsertStatVaildation(matchId);

        // 기존에 데이터 저장되어있는지 체크
        boolean isMatchIdExist =
                fullRecordRepositoryJPA.existsById(matchId);
        if(!isMatchIdExist){
            // fullrecordDTO받아오기
            fullRecordRepository.InsertFullRecord(
                    GetFullRecordFromMatchDTOBean.exec(GetMatchDTOBean.exec(matchId))
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
