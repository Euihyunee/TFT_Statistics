package com.grassparty.tft.Bean;

import com.grassparty.tft.Bean.Small.*;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Model.DTO.MetaRecordDTO;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import com.grassparty.tft.Repository.FullRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMatchHistoryByNameBean {
    @Autowired
    FullRecordRepository fullRecordRepository;
    @Autowired
    GetSummonerDTOByNameBean getSummonerDTOByNameBean;
    @Autowired
    GetMatchIDBean getMatchIDBean;
    @Autowired
    GetMetaRecordFromFullRecordBean getMetaRecordFromFullRecordBean;
    @Autowired
    GetMatchDTOBean getMatchDTOBean;
    @Autowired
    GetFullRecordFromMatchDTOBean getFullRecordFromMatchDTOBean;


    public MetaRecordDTO[] exec(String name){
        // puuid 요청
        SummonerDTO summonerDTO = getSummonerDTOByNameBean.exec(name);

        // matchid 받기
        MatchID matchID = getMatchIDBean.exec(summonerDTO);

        // FullMatchDTO를 MetaRecordDTO로 변환
        MetaRecordDTO[] metaRecordDTOs = new MetaRecordDTO[10];


        for(int i=0; i < matchID.getMatchid().length; i++){
            if (fullRecordRepository.IsExistByMatchid(matchID.getMatchid()[i])){

                // fullRecordDTO를 Matchid로 가져오기(단수)
                RecordDTO recordDTO = fullRecordRepository.GetFullRecordDTOFromRepository(matchID.getMatchid()[i]);

                metaRecordDTOs[i] = getMetaRecordFromFullRecordBean.exec(recordDTO, summonerDTO.getPuuid());

            }else{ // matchid가 DB에 없을 떄 경우
                // matchID로 matchDTO 받기 x 15
                MatchDto matchDto = getMatchDTOBean.exec(matchID.getMatchid()[i]);

                // matchDTO FullMatchDTO로 받기
                RecordDTO recordDTO;
                recordDTO = getFullRecordFromMatchDTOBean.exec(matchDto);

                // FullRecord DB 저장
                fullRecordRepository.InsertFullRecord(recordDTO);

                // FullMatchDTO를 MetaRecordDTO로 변환
                metaRecordDTOs[i] = getMetaRecordFromFullRecordBean.exec(recordDTO, summonerDTO.getPuuid());
            }
        }
        return metaRecordDTOs;
    }
}
