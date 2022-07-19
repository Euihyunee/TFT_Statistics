package com.grassparty.tft.Service;

import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class StatService {
    @Autowired
    private SummonerService summonerService = new SummonerService();
    @Autowired
    private MatchDTOService matchservice = new MatchDTOService();
    @Autowired
    private MetaRecordService metaRecordService = new MetaRecordService();
    @Autowired
    private ModelConvertService modelConvertService = new ModelConvertService();

    public void StatisticsByName(String name){
        // 이름을 받아서 puuid 얻음
        SummonerDTO summonerDTO = summonerService.GetSummonerDTOByName(name);

        // puuid로 통계로직에 들어감
        StatisticsByPuuid(summonerDTO.getPuuid());
    }

    public void StatisticsByPuuid(String puuid){
        SummonerDTO summonerDTO = summonerService.GetSummonerDtoByPuuid(puuid);

        matchservice.GetMatchIdByPuuid(puuid);
    }

    public void StatisticsByMatchId(String matchId){
        // 밸리데이션 체크

        // 기존에 데이터 저장되어있는지 체크

        // 저장되어있다면 PASS

        // 저장되어 있지 않다면 ? RIOT 요청


    }



}
