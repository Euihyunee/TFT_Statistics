package com.grassparty.tft;

import com.grassparty.tft.History.Repository.FullRecordRepository;
import com.grassparty.tft.History.Service.MatchDTOService;
import com.grassparty.tft.History.Service.ModelConvertService;
import com.grassparty.tft.History.Service.SummonerService;
import com.grassparty.tft.Model.DTO.FullRecordDTO;
import com.grassparty.tft.Model.DTO.FullRecordDTOs;
import com.grassparty.tft.Model.DTO.MetaRecordDTO;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.MatchDtos;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test/history")
@CrossOrigin("*")
public class HistoryTestController {
    @Autowired
    MatchDTOService matchservice;
    @Autowired
    ModelConvertService modelConvertService;
    @Autowired
    SummonerService summonerService;
    @Autowired
    FullRecordRepository fullRecordRepository;


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

}
