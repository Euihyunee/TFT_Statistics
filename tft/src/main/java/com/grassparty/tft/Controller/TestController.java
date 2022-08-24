package com.grassparty.tft.Controller;

import com.grassparty.tft.Model.DB.StatPreServiceTable;
import com.grassparty.tft.Model.DTO.FullRecordDTO;
import com.grassparty.tft.Model.DTO.FullRecordDTOs;
import com.grassparty.tft.Model.DTO.MetaRecordDTO;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.MatchDtos;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import com.grassparty.tft.Model.DTO.StatisticDTO;
import com.grassparty.tft.Repository.JPA.CustomPreQueryRepository;
import com.grassparty.tft.Repository.JPA.CustomQueryRepository;
import com.grassparty.tft.Repository.StatPreServiceRepository;
import com.grassparty.tft.Service.*;
import com.grassparty.tft.Repository.FullRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
@CrossOrigin("*")
public class TestController {
    @Autowired SummonerService summonerService;
    @Autowired MatchDTOService matchservice;
    @Autowired MetaRecordService metaRecordService;
    @Autowired ModelConvertService modelConvertService;
    @Autowired FullRecordRepository fullRecordRepository;
    @Autowired StatService statService;
    @Autowired CustomQueryRepository customQueryRepository;
    @Autowired CustomPreQueryRepository customPreQueryRepository;
    @Autowired StatPreServiceRepository statPreServiceRepository;

    @GetMapping("/test1111")
    public StatPreServiceTable test1111(){return statPreServiceRepository.testPrintCount();}

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
        List<StatPreServiceTable> preServiceTables = customPreQueryRepository.findAll();
        StatPreServiceTable dummy;
        for(int i=0; i< preServiceTables.size(); i++){
            StatisticDTO statisticDTO = new StatisticDTO();
            dummy = preServiceTables.get(i);
            statisticDTO.setPlacementRate(dummy.getPlacement() / dummy.getCount());
            statisticDTO.setCharacter_id(FuckThatShit(dummy));
            statisticDTOs.add(statisticDTO);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(statisticDTOs);



        return statisticDTOs;
    }
    public String[] FuckThatShit(StatPreServiceTable statPreServiceTable){
        ArrayList<String> sexsex = new ArrayList<String>();
        if(statPreServiceTable.getTFT7_Aatrox() == 1){
            sexsex.add("TFT7_Nidalee");
        }
        if(statPreServiceTable.getTFT7_Leona() == 1){
            sexsex.add("TFT7_Leona");
        }
        if(statPreServiceTable.getTFT7_Vladimir() == 1){
            sexsex.add("TFT7_Vladimir");
        }
        if(statPreServiceTable.getTFT7_Senna() == 1){
            sexsex.add("TFT7_Senna");
        }
        if(statPreServiceTable.getTFT7_Sejuani() == 1){
            sexsex.add("TFT7_Sejuani");
        }
        if(statPreServiceTable.getTFT7_Sett() == 1){
            sexsex.add("TFT7_Sett");
        }
        if(statPreServiceTable.getTFT7_Skarner() == 1){
            sexsex.add("TFT7_Skarner");
        }
        if(statPreServiceTable.getTFT7_Aatrox() == 1){
            sexsex.add("TFT7_Aatrox");
        }
        if(statPreServiceTable.getTFT7_Ezreal() == 1){
            sexsex.add("TFT7_Ezreal");
        }
        if(statPreServiceTable.getTFT7_Taric() == 1){
            sexsex.add("TFT7_Taric");
        }
        if(statPreServiceTable.getTFT7_Karma() == 1){
            sexsex.add("TFT7_Karma");
        }
        if(statPreServiceTable.getTFT7_TahmKench() == 1){
            sexsex.add("TFT7_TahmKench");
        }
        if(statPreServiceTable.getTFT7_Heimerdinger() == 1){
            sexsex.add("TFT7_Heimerdinger");
        }
        if(statPreServiceTable.getTFT7_Gnar() == 1){
            sexsex.add("TFT7_Gnar");
        }
        if(statPreServiceTable.getTFT7_Nami() == 1){
            sexsex.add("TFT7_Nami");
        }
        if(statPreServiceTable.getTFT7_Lillia() == 1){
            sexsex.add("TFT7_Lillia");
        }
        if(statPreServiceTable.getTFT7_Braum() == 1){
            sexsex.add("TFT7_Braum");
        }
        if(statPreServiceTable.getTFT7_Shen() == 1){
            sexsex.add("TFT7_Shen");
        }
        if(statPreServiceTable.getTFT7_Thresh() == 1){
            sexsex.add("TFT7_Thresh");
        }
        if(statPreServiceTable.getTFT7_Ashe() == 1){
            sexsex.add("TFT7_Ashe");
        }
        if(statPreServiceTable.getTFT7_Yone() == 1){
            sexsex.add("TFT7_Yone");
        }
        if(statPreServiceTable.getTFT7_Jinx() == 1){
            sexsex.add("TFT7_Jinx");
        }
        if(statPreServiceTable.getTFT7_Kayn() == 1){
            sexsex.add("TFT7_Kayn");
        }
        if(statPreServiceTable.getTFT7_Qiyana() == 1){
            sexsex.add("TFT7_Qiyana");
        }
        if(statPreServiceTable.getTFT7_Tristana() == 1){
            sexsex.add("TFT7_Tristana");
        }
        if(statPreServiceTable.getTFT7_Twitch() == 1){
            sexsex.add("TFT7_Twitch");
        }
        if(statPreServiceTable.getTFT7_Nunu() == 1){
            sexsex.add("TFT7_Nunu");
        }
        if(statPreServiceTable.getTFT7_Diana() == 1){
            sexsex.add("TFT7_Diana");
        }
        if(statPreServiceTable.getTFT7_Ryze() == 1){
            sexsex.add("TFT7_Ryze");
        }
        if(statPreServiceTable.getTFT7_Lulu() == 1){
            sexsex.add("TFT7_Lulu");
        }
        if(statPreServiceTable.getTFT7_LeeSin() == 1){
            sexsex.add("TFT7_LeeSin");
        }
        if(statPreServiceTable.getTFT7_Varus() == 1){
            sexsex.add("TFT7_Varus");
        }
        if(statPreServiceTable.getTFT7_Volibear() == 1){
            sexsex.add("TFT7_Volibear");
        }
        if(statPreServiceTable.getTFT7_Sylas() == 1){
            sexsex.add("TFT7_Sylas");
        }
        if(statPreServiceTable.getTFT7_Swain() == 1){
            sexsex.add("TFT7_Swain");
        }
        if(statPreServiceTable.getTFT7_Anivia() == 1){
            sexsex.add("TFT7_Anivia");
        }
        if(statPreServiceTable.getTFT7_Elise() == 1){
            sexsex.add("TFT7_Elise");
        }
        if(statPreServiceTable.getTFT7_Olaf() == 1){
            sexsex.add("TFT7_Olaf");
        }
        if(statPreServiceTable.getTFT7_Illaoi() == 1){
            sexsex.add("TFT7_Illaoi");
        }
        if(statPreServiceTable.getTFT7_Neeko() == 1){
            sexsex.add("TFT7_Neeko");
        }
        if(statPreServiceTable.getTFT7_Sona() == 1){
            sexsex.add("TFT7_Sona");
        }
        if(statPreServiceTable.getTFT7_Ornn() == 1){
            sexsex.add("TFT7_Ornn");
        }
        if(statPreServiceTable.getTFT7_Xayah() == 1){
            sexsex.add("TFT7_Xayah");
        }
        if(statPreServiceTable.getTFT7_Corki() == 1){
            sexsex.add("TFT7_Corki");
        }
        if(statPreServiceTable.getTFT7_Talon() == 1){
            sexsex.add("TFT7_Talon");
        }
        if(statPreServiceTable.getTFT7_Hecarim() == 1){
            sexsex.add("TFT7_Hecarim");
        }
        if(statPreServiceTable.getTFT7_Bard() == 1){
            sexsex.add("TFT7_Bard");
        }
        if(statPreServiceTable.getTFT7_Soraka() == 1){
            sexsex.add("TFT7_Soraka");
        }
        if(statPreServiceTable.getTFT7_Yasuo() == 1){
            sexsex.add("TFT7_Yasuo");
        }
        if(statPreServiceTable.getTFT7_Zoe() == 1){
            sexsex.add("TFT7_Zoe");
        }
        if(statPreServiceTable.getTFT7_Pyke() == 1){
            sexsex.add("TFT7_Pyke");
        }
        if(statPreServiceTable.getTFT7_DragonBlue() == 1){
            sexsex.add("TFT7_DragonBlue");
        }
        if(statPreServiceTable.getTFT7_DragonGold() == 1){
            sexsex.add("TFT7_DragonGold");
        }
        if(statPreServiceTable.getTFT7_DragonPurple() == 1){
            sexsex.add("TFT7_DragonPurple");
        }
        if(statPreServiceTable.getTFT7_DragonGreen() == 1){
            sexsex.add("TFT7_DragonGreen");
        }
        if(statPreServiceTable.getTFT7_TrainerDragon() == 1){
            sexsex.add("TFT7_TrainerDragon");
        }
        if(statPreServiceTable.getTFT7_AoShin() == 1){
            sexsex.add("TFT7_AoShin");
        }
        if(statPreServiceTable.getTFT7_AurelionSol() == 1){
            sexsex.add("TFT7_AurelionSol");
        }
        if(statPreServiceTable.getTFT7_Shyvana() == 1){
            sexsex.add("TFT7_Shyvana");
        }

        System.out.println("---------------------------------------------------------------------------");
        System.out.println(sexsex);


        String[] sex = sexsex.toArray(new String[sexsex.size()]);
        return sex;
    }
}
