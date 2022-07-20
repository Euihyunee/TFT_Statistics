package com.grassparty.tft.Controller;

import com.grassparty.tft.Model.DB.StatPreServiceTable;
import com.grassparty.tft.Model.FullRecordDTO;
import com.grassparty.tft.Model.FullRecordDTOs;
import com.grassparty.tft.Model.MetaRecordDTO;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.MatchDtos;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import com.grassparty.tft.Model.StatisticDTO;
import com.grassparty.tft.Repository.JPA.CustomQueryRepository;
import com.grassparty.tft.Service.*;
import com.grassparty.tft.Repository.FullRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired SummonerService summonerService;
    @Autowired MatchDTOService matchservice;
    @Autowired MetaRecordService metaRecordService;
    @Autowired ModelConvertService modelConvertService;
    @Autowired
    FullRecordRepository fullRecordRepository;
    @Autowired StatService statService;
    @Autowired
    CustomQueryRepository customQueryRepository;

    // 문자열 출력 테스트
    @GetMapping(path = "/{test}")
    public String test(@PathVariable String test) {
        return test;
    }

    // 메타레코드 더미데이터 테스트
    @GetMapping(path = "/MetaRecord")
    public MetaRecordDTO test() {
        return metaRecordService.GetDummyDTO();
    }

    // UTF-8 테스트
    @GetMapping(path = "/UTF-8/{name}")
    public String GetEncodeByName(@PathVariable String name) {
        return summonerService.GetEncode(name);
    }

    // GetFullRecordFromMatchDTO test
    @GetMapping(path = "/GetFull")
    public FullRecordDTO testGetFullRecordFromMatchDTO() {
        MatchDto matchDto = matchservice.GetMatchDTOByMatchId("KR_5988203332");

        return modelConvertService.GetFullRecordFromMatchDTO(matchDto);
    }

    // 작동
    @GetMapping("/test1/{name}")
    public SummonerDTO test1(@PathVariable String name) {
        // puuid 요청
        SummonerDTO summonerDTO = summonerService.GetSummonerDTOByName(name);
        return summonerDTO;
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
    public FullRecordDTOs testGetMatchHistoryByName(@PathVariable String name) {
        // puuid 요청
        SummonerDTO summonerDTO = summonerService.GetSummonerDTOByName(name);

        // matchid 받기
        MatchID matchID = matchservice.GetMatchIdByPuuid(summonerDTO.getPuuid());

        // matchID로 matchDTO 받기 x 15
        MatchDtos matchDtos = matchservice.GetMatchDTOByMatchIds(matchID);

        // matchDTO FullMatchDTO로 받기
        FullRecordDTOs fullRecordDTOs;
        fullRecordDTOs = modelConvertService.GetFullRecordsFromMatchDTOs(matchDtos);

        // FullRecord DB 저장
        fullRecordRepository.InsertFullRecords(fullRecordDTOs.getFullRecordDTOs());

        // FullRecordDTO list 리턴
        return fullRecordDTOs;
    }

    // IsExistByMatchid
    // GetFullRecordDTOFromRepository
    // DB insert 작동 확인
    @GetMapping("/Database/{name}")
    public MetaRecordDTO[] testDBByName(@PathVariable String name) {
        // puuid 요청
        SummonerDTO summonerDTO = summonerService.GetSummonerDTOByName(name);

        // matchid 받기
        MatchID matchID = matchservice.GetMatchIdByPuuid(summonerDTO.getPuuid());


        // FullMatchDTO를 MetaRecordDTO로 변환
        MetaRecordDTO[] metaRecordDTOs = new MetaRecordDTO[10];


        for(int i=0; i < matchID.getMatchid().length; i++){
            if (fullRecordRepository.IsExistByMatchid(matchID.getMatchid()[i])){

    //             fullRecordDTO를 Matchid로 가져오기(단수)
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

    @GetMapping("/dbselect/{puuid}")
    public void testselect(@PathVariable String puuid) {

        fullRecordRepository.IsExistByMatchid(puuid);

    }
    // statService 테스트입니당
    @GetMapping("/DBTest1/{matchid}")
    public void testDBTest1(@PathVariable String matchid){

        statService.StatisticsByMatchId(matchid);
    }

    @GetMapping("/mockdoridomabem")
    public ArrayList<StatisticDTO> mockdoridomabem(){
        ArrayList<StatisticDTO> statisticDTOs = new ArrayList<StatisticDTO>();
        StatisticDTO statisticDTO = new StatisticDTO();
        List<StatPreServiceTable> preServiceTables = customQueryRepository.findAll();
        StatPreServiceTable dummy;
        for(int i=0; i< preServiceTables.size(); i++){
            dummy = preServiceTables.get(i);
            statisticDTO.setPlacementRate(dummy.getPlacement() / dummy.getCount());
            statisticDTO.setCharacter_id(FuckThatShit(dummy));
        }



        return statisticDTOs;
    }
    public String[] FuckThatShit(StatPreServiceTable statPreServiceTable){
        ArrayList<String> sexsex = new ArrayList<String>();
        if(statPreServiceTable.getTFT7_Aatrox() == 1){
            sexsex.add("TFT7_Aatrox");
        }
        if(statPreServiceTable.getTFT7_Aatrox() == 1){
            sexsex.add("TFT7_Aatrox");
        }
        if(statPreServiceTable.getTFT7_Aatrox() == 1){
            sexsex.add("TFT7_Aatrox");
        }
        if(statPreServiceTable.getTFT7_Aatrox() == 1){
            sexsex.add("TFT7_Aatrox");
        }
        if(statPreServiceTable.getTFT7_Aatrox() == 1){
            sexsex.add("TFT7_Aatrox");
        }
        if(statPreServiceTable.getTFT7_Aatrox() == 1){
            sexsex.add("TFT7_Aatrox");
        }
        if(statPreServiceTable.getTFT7_Aatrox() == 1){
            sexsex.add("TFT7_Aatrox");
        }


        String[] sex = sexsex.toArray(new String[sexsex.size()]);
        return sex;
    }
}
