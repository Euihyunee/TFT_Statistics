package com.grassparty.tft.Controller;

import com.grassparty.tft.Model.FullRecordDTO;
import com.grassparty.tft.Model.Riot.MatchDto;
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

//    @GetMapping(path="/puuid/{puuid}")
//    public SummonerDTO GetDTOByPuuid(@PathVariable String puuid){ return summonerService.GetSummonerDtoByPuuid(puuid);}

//    @GetMapping(path="/name/{name}")
//    public SummonerDTO GetDTOByName(@PathVariable String name){ return summonerService.GetSummonerDTOByName(name);}


    // 문자열 출력 테스트
    @GetMapping(path="/test/{test}")
    public String test(@PathVariable String test){ return test;}
    // 메타레코드 더미데이터 테스트
    @GetMapping(path="/test/MetaRecord")
    public MetaRecordDTO test(){ return metaRecordService.GetDummyDTO();}
    // UTF-8 테스트
    @GetMapping(path="/UTF-8/{name}")
    public String GetEncodeByName(@PathVariable String name){ return summonerService.GetEncode(name);}

    @GetMapping(path="/MatchID/{matchid}")
    public MatchDto GetMatchDTO(@PathVariable String matchid){return matchservice.GetMatchDTOByMatchId(matchid);}

    @GetMapping(path="/puuid/{puuid}")
    public MatchID GetMatchID(@PathVariable String puuid){return matchservice.GetMatchIdByPuuid(puuid);}

    // GetFullRecordFromMatchDTO test
    @GetMapping(path="/test/GetFull")
    public FullRecordDTO testGetFullRecordFromMatchDTO(){
        MatchDto matchDto = matchservice.GetMatchDTOByMatchId("KR_5988203332");

        return modelConvertService.GetFullRecordFromMatchDTO(matchDto);
    }
//    @GetMapping(path="/name/{name}")
//    public MatchDto GetMatchDTOByName(@PathVariable String name){
//        SummonerDTO summonerDTO = summonerService.GetSummonerDTOByName(name);
//        MatchID matchID = matchservice.GetMatchIdByPuuid(summonerDTO.getPuuid());
//        return matchservice.GetMatchDTOByMatchId(matchID.toString());
//    }
}
