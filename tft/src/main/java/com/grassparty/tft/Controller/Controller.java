package com.grassparty.tft.Controller;

import com.grassparty.tft.Model.FullRecordDTO;
import com.grassparty.tft.Model.FullRecordDTOs;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.MatchDtos;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import com.grassparty.tft.Service.MatchDTOService;
import com.grassparty.tft.Model.MetaRecordDTO;
import com.grassparty.tft.Service.MetaRecordService;
import com.grassparty.tft.Service.ModelConvertService;
import com.grassparty.tft.Service.RepositoryService.FullRecordRepositoryCreate;
import com.grassparty.tft.Service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    private SummonerService summonerService = new SummonerService();
    @Autowired
    private MatchDTOService matchservice = new MatchDTOService();
    @Autowired
    private MetaRecordService metaRecordService = new MetaRecordService();
    @Autowired
    private ModelConvertService modelConvertService = new ModelConvertService();
    @Autowired
    private FullRecordRepositoryCreate fullRecordRepositoryCreate = new FullRecordRepositoryCreate();




    @GetMapping("/")
    public String helloDTO(){ return "hello";}

    // 인덱스
    @GetMapping("/GetMatchHistory/{name}")
    public MetaRecordDTO[] GetMatchHistoryByName(@PathVariable String name){
        // puuid 요청
        SummonerDTO summonerDTO = summonerService.GetSummonerDTOByName(name);

        // matchid 받기
        MatchID matchID = matchservice.GetMatchIdByPuuid(summonerDTO.getPuuid());


        // FullMatchDTO를 MetaRecordDTO로 변환
        MetaRecordDTO[] metaRecordDTOs = new MetaRecordDTO[10];


        for(int i=0; i < matchID.getMatchid().length; i++){
            if (fullRecordRepositoryCreate.IsExistByMatchid(matchID.getMatchid()[i])){

                //             fullRecordDTO를 Matchid로 가져오기(단수)
                FullRecordDTO fullRecordDTO = fullRecordRepositoryCreate.GetFullRecordDTOFromRepository(matchID.getMatchid()[i]);

                metaRecordDTOs[i] = modelConvertService.GetMetaRecordFromFullRecord(fullRecordDTO, summonerDTO.getPuuid());

            }else{ // matchid가 DB에 없을 떄 경우
                // matchID로 matchDTO 받기 x 15
                MatchDto matchDto = matchservice.GetMatchDTOByMatchId(matchID.getMatchid()[i]);

                // matchDTO FullMatchDTO로 받기
                FullRecordDTO fullRecordDTO;
                fullRecordDTO = modelConvertService.GetFullRecordFromMatchDTO(matchDto);

                // FullRecord DB 저장
                fullRecordRepositoryCreate.InsertFullRecord(fullRecordDTO);

                // FullMatchDTO를 MetaRecordDTO로 변환
                metaRecordDTOs[i] = modelConvertService.GetMetaRecordFromFullRecord(fullRecordDTO, summonerDTO.getPuuid());
            }
        }
        return metaRecordDTOs;
    }

    // 세부 항목 가져오기
    @GetMapping(path="/GetRecord/{matchid}")
    public FullRecordDTO GetRecordByMatchId(@PathVariable String matchid){
        // matchid 로 matchDTO 받기
        MatchDto matchDto = matchservice.GetMatchDTOByMatchId(matchid);

        // matchDTO를 FullRecordDTo로 변환
        FullRecordDTO fullRecordDTO;
        fullRecordDTO = modelConvertService.GetFullRecordFromMatchDTO(matchDto);

        return fullRecordDTO;
    }

    @GetMapping(path="/MatchID/{matchId}")
    public MatchDto GetMatchDTO(@PathVariable String matchId){return matchservice.GetMatchDTOByMatchId(matchId);}

    @GetMapping(path="/puuid/{puuid}")
    public MatchID GetMatchID(@PathVariable String puuid){return matchservice.GetMatchIdByPuuid(puuid);}

}
