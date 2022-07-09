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



    @GetMapping("/")
    public String helloDTO(){ return "hello";}

    // 인덱스
    @GetMapping("/GetMatchHistory/{name}")
    public FullRecordDTOs GetMatchHistoryByName(String name){
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


//    @GetMapping(path="/puuid/{puuid}")
//    public SummonerDTO GetDTOByPuuid(@PathVariable String puuid){ return summonerService.GetSummonerDtoByPuuid(puuid);}

//    @GetMapping(path="/name/{name}")
//    public SummonerDTO GetDTOByName(@PathVariable String name){ return summonerService.GetSummonerDTOByName(name);}


    @GetMapping(path="/MatchID/{matchid}")
    public MatchDto GetMatchDTO(@PathVariable String matchid){return matchservice.GetMatchDTOByMatchId(matchid);}

    @GetMapping(path="/puuid/{puuid}")
    public MatchID GetMatchID(@PathVariable String puuid){return matchservice.GetMatchIdByPuuid(puuid);}


}
