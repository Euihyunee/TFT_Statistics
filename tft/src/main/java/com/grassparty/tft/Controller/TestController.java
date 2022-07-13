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

    // 작동
    @GetMapping("/test1/{name}")
    public SummonerDTO test1(@PathVariable String name) {
        // puuid 요청
        SummonerDTO summonerDTO = summonerService.GetSummonerDTOByName(name);
        return summonerDTO;

        // matchid 받기
        //MatchID matchID = matchservice.GetMatchIdByPuuid(summonerDTO.getPuuid());

        // matchID로 matchDTO 받기 x 15
        //MatchDtos matchDtos = matchservice.GetMatchDTOByMatchIds(matchID);
    }
    // 작동
    @GetMapping("/test2/{name}")
    public MatchID test2(@PathVariable String name) {
        // puuid 요청
        SummonerDTO summonerDTO = summonerService.GetSummonerDTOByName(name);

        // matchid 받기
        MatchID matchID = matchservice.GetMatchIdByPuuid(summonerDTO.getPuuid());
        return matchID;
    }
    // 작동
    @GetMapping("/test3/{name}")
    public MatchDtos test3(@PathVariable String name) {
        // puuid 요청
        SummonerDTO summonerDTO = summonerService.GetSummonerDTOByName(name);

        // matchid 받기
        MatchID matchID = matchservice.GetMatchIdByPuuid(summonerDTO.getPuuid());

        // matchID로 matchDTO 받기 x 15
        MatchDtos matchDtos = matchservice.GetMatchDTOByMatchIds(matchID);

        return matchDtos;
    }
    // 작동
    @GetMapping("/test4/{name}")
    public FullRecordDTOs test4(@PathVariable String name) {
        // puuid 요청
        SummonerDTO summonerDTO = summonerService.GetSummonerDTOByName(name);

        // matchid 받기
        MatchID matchID = matchservice.GetMatchIdByPuuid(summonerDTO.getPuuid());

        // matchID로 matchDTO 받기 x 15
        MatchDtos matchDtos = matchservice.GetMatchDTOByMatchIds(matchID);

        // matchDTO FullMatchDTO로 받기
        FullRecordDTOs fullRecordDTOs;
        fullRecordDTOs = modelConvertService.GetFullRecordsFromMatchDTOs(matchDtos);

        // FullMatchDTO list 리턴
        return fullRecordDTOs;
    }
    // 작동
    @GetMapping("/test5/{name}")
    public MetaRecordDTO test5(@PathVariable String name) {
        // puuid 요청
        SummonerDTO summonerDTO = summonerService.GetSummonerDTOByName(name);

        // matchid 받기
        MatchID matchID = matchservice.GetMatchIdByPuuid(summonerDTO.getPuuid());

        // matchID로 matchDTO 받기 x 15
        MatchDtos matchDtos = matchservice.GetMatchDTOByMatchIds(matchID);

        // matchDTO FullMatchDTO로 받기
        FullRecordDTOs fullRecordDTOs;
        fullRecordDTOs = modelConvertService.GetFullRecordsFromMatchDTOs(matchDtos);

        // FullMatchDTO를 MetaRecordDTO로 변환
        MetaRecordDTO metaRecordDTO;
        metaRecordDTO = modelConvertService.GetMetaRecordFromFullRecord(fullRecordDTOs.getFullRecordDTOs()[0], summonerDTO.getPuuid());

        return metaRecordDTO;
    }
    // 작동
    @GetMapping("/test6/{name}")
    public MetaRecordDTO test6(@PathVariable String name) {
        // puuid 요청
        SummonerDTO summonerDTO = summonerService.GetSummonerDTOByName(name);

        // matchid 받기
        MatchID matchID = matchservice.GetMatchIdByPuuid(summonerDTO.getPuuid());

        // matchID로 matchDTO 받기 x 15
        MatchDtos matchDtos = matchservice.GetMatchDTOByMatchIds(matchID);

        // matchDTO FullMatchDTO로 받기
        FullRecordDTOs fullRecordDTOs;
        fullRecordDTOs = modelConvertService.GetFullRecordsFromMatchDTOs(matchDtos);

        // FullMatchDTO를 MetaRecordDTO로 변환
        MetaRecordDTO metaRecordDTO;
        metaRecordDTO = modelConvertService.GetMetaRecordFromFullRecord(fullRecordDTOs.getFullRecordDTOs()[0], summonerDTO.getPuuid());

        return metaRecordDTO;
    }

    @GetMapping("/test7/{name}")
    public MetaRecordDTO[] test7(@PathVariable String name) {
        // puuid 요청
        SummonerDTO summonerDTO = summonerService.GetSummonerDTOByName(name);

        // matchid 받기
        MatchID matchID = matchservice.GetMatchIdByPuuid(summonerDTO.getPuuid());

        // matchID로 matchDTO 받기 x 15
        MatchDtos matchDtos = matchservice.GetMatchDTOByMatchIds(matchID);

        // matchDTO FullMatchDTO로 받기
        FullRecordDTOs fullRecordDTOs;
        fullRecordDTOs = modelConvertService.GetFullRecordsFromMatchDTOs(matchDtos);

        // FullMatchDTO를 MetaRecordDTO로 변환
        MetaRecordDTO[] metaRecordDTO;
        metaRecordDTO = modelConvertService.GetMetaRecordsFromFullRecords(fullRecordDTOs.getFullRecordDTOs(), summonerDTO.getPuuid());

        return metaRecordDTO;
    }

    // 전적검색 (작동)
    @GetMapping("/GetMatchHistory/{name}")
    public FullRecordDTOs testGetMatchHistoryByName(@PathVariable String name){
        // puuid 요청
        SummonerDTO summonerDTO = summonerService.GetSummonerDTOByName(name);

        // matchid 받기
        MatchID matchID = matchservice.GetMatchIdByPuuid(summonerDTO.getPuuid());

        // matchID로 matchDTO 받기 x 15
        MatchDtos matchDtos = matchservice.GetMatchDTOByMatchIds(matchID);

        // matchDTO FullMatchDTO로 받기
        FullRecordDTOs fullRecordDTOs;
        fullRecordDTOs = modelConvertService.GetFullRecordsFromMatchDTOs(matchDtos);

        // FullMatchDTO list 리턴
        return fullRecordDTOs;
    }
}
