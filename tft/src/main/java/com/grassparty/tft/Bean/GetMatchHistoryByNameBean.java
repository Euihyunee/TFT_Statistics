package com.grassparty.tft.Bean;

import com.grassparty.tft.Bean.Small.*;
import com.grassparty.tft.Model.DTO.FullRecordDTO;
import com.grassparty.tft.Model.DTO.MetaRecordDTO;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import com.grassparty.tft.Repository.FullRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GetMatchHistoryByNameBean {
    @Autowired
    FullRecordRepository fullRecordRepository;

    GetSummonerDTOByNameBean getSummonerDTOByNameBean = new GetSummonerDTOByNameBean();
    com.grassparty.tft.Bean.GetMatchIDBean GetMatchIDBean = new GetMatchIDBean();
    com.grassparty.tft.Bean.Small.GetMetaRecordFromFullRecordBean GetMetaRecordFromFullRecordBean = new GetMetaRecordFromFullRecordBean();
    com.grassparty.tft.Bean.GetMatchDTOBean GetMatchDTOBean = new GetMatchDTOBean();
    com.grassparty.tft.Bean.Small.GetFullRecordFromMatchDTOBean GetFullRecordFromMatchDTOBean = new GetFullRecordFromMatchDTOBean();



    public MetaRecordDTO[] exec(String name){
        // puuid 요청
        SummonerDTO summonerDTO = getSummonerDTOByNameBean.exec(name);

        // matchid 받기
        MatchID matchID = GetMatchIDBean.exec(summonerDTO.getPuuid());

        // FullMatchDTO를 MetaRecordDTO로 변환
        MetaRecordDTO[] metaRecordDTOs = new MetaRecordDTO[10];


        for(int i=0; i < matchID.getMatchid().length; i++){
            if (fullRecordRepository.IsExistByMatchid(matchID.getMatchid()[i])){

                // fullRecordDTO를 Matchid로 가져오기(단수)
                FullRecordDTO fullRecordDTO = fullRecordRepository.GetFullRecordDTOFromRepository(matchID.getMatchid()[i]);

                metaRecordDTOs[i] = GetMetaRecordFromFullRecordBean.exec(fullRecordDTO, summonerDTO.getPuuid());

            }else{ // matchid가 DB에 없을 떄 경우
                // matchID로 matchDTO 받기 x 15
                MatchDto matchDto = GetMatchDTOBean.exec(matchID.getMatchid()[i]);

                // matchDTO FullMatchDTO로 받기
                FullRecordDTO fullRecordDTO;
                fullRecordDTO = GetFullRecordFromMatchDTOBean.exec(matchDto);

                // FullRecord DB 저장
                fullRecordRepository.InsertFullRecord(fullRecordDTO);

                // FullMatchDTO를 MetaRecordDTO로 변환
                metaRecordDTOs[i] = GetMetaRecordFromFullRecordBean.exec(fullRecordDTO, summonerDTO.getPuuid());
            }
        }
        return metaRecordDTOs;
    }
}
