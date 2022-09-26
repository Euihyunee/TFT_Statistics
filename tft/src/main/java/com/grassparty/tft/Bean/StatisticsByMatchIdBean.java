package com.grassparty.tft.Bean;

import com.grassparty.tft.History.Repository.FullRecordRepository;
import com.grassparty.tft.History.Repository.JPA.FullRecordRepositoryJPA;
import com.grassparty.tft.History.Repository.JPA.StatVaildationRepositoryJPA;
import com.grassparty.tft.History.Service.MatchDTOService;
import com.grassparty.tft.History.Service.ModelConvertService;
import com.grassparty.tft.Model.DB.StatValidationTable;
import org.springframework.beans.factory.annotation.Autowired;

public class StatisticsByMatchIdBean {

    @Autowired
    MatchDTOService matchservice;
    @Autowired
    ModelConvertService modelConvertService;
    @Autowired
    FullRecordRepositoryJPA fullRecordRepositoryJPA;
    @Autowired
    FullRecordRepository fullRecordRepository;
    @Autowired
    StatVaildationRepositoryJPA statVaildationRepositoryJPA;

    public void exec(String matchId){
        // 밸리데이션 체크
        InsertStatVaildation(matchId);

        // 기존에 데이터 저장되어있는지 체크
        boolean isMatchIdExist =
                fullRecordRepositoryJPA.existsById(matchId);
        if(!isMatchIdExist){
            // fullrecordDTO받아오기
            fullRecordRepository.InsertFullRecord(
                    modelConvertService.GetFullRecordFromMatchDTO(
                            matchservice.GetMatchDTOByMatchId(matchId))
            );
        }
    }
    public void InsertStatVaildation(String matchId){
        StatValidationTable statValidationTable = StatValidationTable.builder()
                .matchID(matchId)
                .valid(false)
                .build();
        statVaildationRepositoryJPA.save(statValidationTable);
    }
}
