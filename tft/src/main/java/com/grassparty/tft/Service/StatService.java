package com.grassparty.tft.Service;

import com.grassparty.tft.Model.DB.StatValidationTable;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import com.grassparty.tft.Repository.FullRecordRepositoryJPA;
import com.grassparty.tft.Repository.FullRecordRepository;
import com.grassparty.tft.Repository.StatVaildationRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatService {
    @Autowired SummonerService summonerService;
    @Autowired MatchDTOService matchservice;
    @Autowired MetaRecordService metaRecordService;
    @Autowired ModelConvertService modelConvertService;
    @Autowired
    FullRecordRepository fullRecordRepository;
    @Autowired
    StatVaildationRepositoryJPA statVaildationRepositoryJPA;
    @Autowired
    FullRecordRepositoryJPA fullRecordRepositoryJPA;

    public void StatisticsByName(String name){
        // 이름을 받아서 puuid 얻음
        SummonerDTO summonerDTO = summonerService.GetSummonerDTOByName(name);

        // puuid로 통계로직에 들어감
        StatisticsByPuuid(summonerDTO.getPuuid());
    }

    public void StatisticsByPuuid(String puuid){
        SummonerDTO summonerDTO = summonerService.GetSummonerDtoByPuuid(puuid);

        matchservice.GetMatchIdByPuuid(puuid);
    }

    public void StatisticsByMatchId(String matchId){
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
