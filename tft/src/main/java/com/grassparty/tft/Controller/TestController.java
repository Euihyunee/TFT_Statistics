package com.grassparty.tft.Controller;

import com.grassparty.tft.Model.FullRecordDTO;
import com.grassparty.tft.Model.FullRecordDTOs;
import com.grassparty.tft.Model.MetaRecordDTO;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.MatchDtos;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import com.grassparty.tft.Service.MatchDTOService;
import com.grassparty.tft.Service.MetaRecordService;
import com.grassparty.tft.Service.ModelConvertService;
import com.grassparty.tft.Service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private SummonerService summonerService = new SummonerService();
    @Autowired
    private MatchDTOService matchservice = new MatchDTOService();
    @Autowired
    private MetaRecordService metaRecordService = new MetaRecordService();
    @Autowired
    private ModelConvertService modelConvertService = new ModelConvertService();


    // 문자열 출력 테스트
    @GetMapping(path="/{test}")
    public String test(@PathVariable String test){ return test;}

    // 메타레코드 더미데이터 테스트
    @GetMapping(path="/MetaRecord")
    public MetaRecordDTO test(){ return metaRecordService.GetDummyDTO();}

    // UTF-8 테스트
    @GetMapping(path="/UTF-8/{name}")
    public String GetEncodeByName(@PathVariable String name){ return summonerService.GetEncode(name);}

    // GetFullRecordFromMatchDTO test
    @GetMapping(path="/GetFull")
    public FullRecordDTO testGetFullRecordFromMatchDTO(){
        MatchDto matchDto = matchservice.GetMatchDTOByMatchId("KR_5988203332");

        return modelConvertService.GetFullRecordFromMatchDTO(matchDto);
    }

    @GetMapping("/GetMatchHistory/{name}")
    public FullRecordDTOs GetMatchHistoryByName(@PathVariable String name){
        // puuid 요청
        SummonerDTO summonerDTO = summonerService.GetSummonerDTOByName(name);

        // matchid 받기
        MatchID matchID = matchservice.GetMatchIdByPuuid(summonerDTO.getPuuid());

        // matchID로 matchDTO 받기 x 15
        MatchDtos matchDtos = matchservice.GetMatchDTOByMatchIds(matchID);

        // matchDTO FullMatchDTO로 받기

        // FullMatchDTO list 리턴
        FullRecordDTOs fullRecordDTOs = new FullRecordDTOs();
        return fullRecordDTOs;
    }

}