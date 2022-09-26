package com.grassparty.tft.History.Controller;

import com.grassparty.tft.History.Repository.FullRecordRepository;
import com.grassparty.tft.History.Service.MatchDTOService;
import com.grassparty.tft.History.Service.MetaRecordService;
import com.grassparty.tft.History.Service.ModelConvertService;
import com.grassparty.tft.History.Service.SummonerService;
import com.grassparty.tft.Model.DTO.FullRecordDTO;
import com.grassparty.tft.Model.DTO.MetaRecordDTO;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class HistoryController {
    @Autowired
    SummonerService summonerService;
    @Autowired
    MatchDTOService matchservice;
    @Autowired
    MetaRecordService metaRecordService;
    @Autowired
    ModelConvertService modelConvertService;
    @Autowired
    FullRecordRepository fullRecordRepository;

    // MetaRecordDTOs 닉네임으로 얻기
    @GetMapping("/GetMatchHistory/{name}")
    public MetaRecordDTO[] GetMatchHistoryByName(@PathVariable String name){
        // puuid 요청
        SummonerDTO summonerDTO = summonerService.GetSummonerDTOByName(name);

        // matchid 받기
        MatchID matchID = matchservice.GetMatchIdByPuuid(summonerDTO.getPuuid());


        // FullMatchDTO를 MetaRecordDTO로 변환
        MetaRecordDTO[] metaRecordDTOs = new MetaRecordDTO[10];


        for(int i=0; i < matchID.getMatchid().length; i++){
            if (fullRecordRepository.IsExistByMatchid(matchID.getMatchid()[i])){

                // fullRecordDTO를 Matchid로 가져오기(단수)
                FullRecordDTO fullRecordDTO = fullRecordRepository.GetFullRecordDTOFromRepository(matchID.getMatchid()[i]);

                metaRecordDTOs[i] = modelConvertService.GetMetaRecordFromFullRecord(fullRecordDTO, summonerDTO.getPuuid());

            }else{ // matchid가 DB에 없을 떄 경우
                // matchID로 matchDTO 받기 x 15
                MatchDto matchDto = matchservice.GetMatchDTOByMatchId(matchID.getMatchid()[i]);

                // matchDTO FullMatchDTO로 받기
                FullRecordDTO fullRecordDTO;
                fullRecordDTO = modelConvertService.GetFullRecordFromMatchDTO(matchDto);

                // FullRecord DB 저장
                fullRecordRepository.InsertFullRecord(fullRecordDTO);

                // FullMatchDTO를 MetaRecordDTO로 변환
                metaRecordDTOs[i] = modelConvertService.GetMetaRecordFromFullRecord(fullRecordDTO, summonerDTO.getPuuid());
            }
        }
        return metaRecordDTOs;
    }

    // matchId로 matchDto를 받아오고 이를 FullRecordDTO로 변환하는 Controller
    @GetMapping(path="/GetRecord/{matchid}")
    public FullRecordDTO GetRecordByMatchId(@PathVariable String matchid){
        // matchid 로 matchDTO 받기
        MatchDto matchDto = matchservice.GetMatchDTOByMatchId(matchid);

        // matchDTO를 FullRecordDTo로 변환
        FullRecordDTO fullRecordDTO;
        fullRecordDTO = modelConvertService.GetFullRecordFromMatchDTO(matchDto);

        return fullRecordDTO;
    }

    // matchId를 가지고 matchDto를 받아오는 Controller
    @GetMapping(path="/MatchID/{matchId}")
    public MatchDto GetMatchDTO(@PathVariable String matchId){return matchservice.GetMatchDTOByMatchId(matchId);}

    // puuid로 matchID받아오는 Controller
    @GetMapping(path="/puuid/{puuid}")
    public MatchID GetMatchID(@PathVariable String puuid){return matchservice.GetMatchIdByPuuid(puuid);}



}
