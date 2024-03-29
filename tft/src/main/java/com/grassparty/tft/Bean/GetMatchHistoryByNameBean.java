package com.grassparty.tft.Bean;

import com.grassparty.tft.Bean.Small.*;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Model.DTO.MetaRecordDTO;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import com.grassparty.tft.Repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMatchHistoryByNameBean {
    @Autowired
    RecordRepository recordRepository;
    @Autowired
    GetSummonerDTOByNameBean getSummonerDTOByNameBean;
    @Autowired
    GetMatchIDBean getMatchIDBean;
    @Autowired
    GetMetaRecordFromFullRecordBean getMetaRecordFromFullRecordBean;
    @Autowired
    GetMatchDTOBean getMatchDTOBean;
    @Autowired
    GetRecordFromMatchDTOBean getRecordFromMatchDTOBean;
    @Autowired
    SaveRecordBean saveRecordBean;


    public MetaRecordDTO[] exec(String name){
        // TODO puuid 요청
        SummonerDTO summonerDTO = getSummonerDTOByNameBean.exec(name);

        // matchid 받기
        MatchID matchID = getMatchIDBean.exec(summonerDTO);

        // FullMatchDTO를 MetaRecordDTO로 변환
        MetaRecordDTO[] metaRecordDTOs = new MetaRecordDTO[10];


        for(int i=0; i < matchID.getMatchid().length; i++){
            if (recordRepository.IsExistByMatchid(matchID.getMatchid()[i])){

                // fullRecordDTO를 Matchid로 가져오기(단수)
                RecordDTO recordDTO = recordRepository.GetRecordDTOFromRepository(matchID.getMatchid()[i]);

                metaRecordDTOs[i] = getMetaRecordFromFullRecordBean.exec(recordDTO, summonerDTO.getPuuid());

            }else{ // matchid가 DB에 없을 떄 경우
                // matchID로 matchDTO 받기 x 15
                MatchDto matchDto = getMatchDTOBean.exec(matchID.getMatchid()[i]);

                // matchDTO FullMatchDTO로 받기
                RecordDTO recordDTO;
                recordDTO = getRecordFromMatchDTOBean.exec(matchDto);

                // FullRecord DB 저장
                saveRecordBean.exec(recordDTO);

                // FullMatchDTO를 MetaRecordDTO로 변환
                metaRecordDTOs[i] = getMetaRecordFromFullRecordBean.exec(recordDTO, summonerDTO.getPuuid());
            }
        }
        return metaRecordDTOs;
    }
}
