package com.grassparty.tft.History.Service;

import com.grassparty.tft.Bean.*;
import com.grassparty.tft.Model.DTO.FullRecordDTO;
import com.grassparty.tft.Model.DTO.MetaRecordDTO;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class HistoryService {
    GetMatchHistoryByNameBean GetMatchHistoryByNameBean = new GetMatchHistoryByNameBean();
    GetRecordByMatchIdBean GetRecordByMatchIdBean = new GetRecordByMatchIdBean();

    // MetaRecordDTOs 닉네임으로 얻기
    public MetaRecordDTO[] GetMatchHistoryByName(String name){
        return GetMatchHistoryByNameBean.exec(name);
    }

    public FullRecordDTO GetRecordByMatchId(String matchid){
        return GetRecordByMatchIdBean.exec(matchid);
    }

    public MatchDto GetMatchDTOByMatchId(String matchid) {
        GetUrlByMatchIdBean GetUrlByMatchIdBean = new GetUrlByMatchIdBean();
        GetMatchDTOBean GetMatchDTOBean = new GetMatchDTOBean();

        return GetMatchDTOBean.exec(GetUrlByMatchIdBean.exec(matchid));
    }

    public MatchID GetMatchIdByPuuid(String puuid){
        GetUrlByPuuidBean GetUrlByPuuidBean = new GetUrlByPuuidBean();
        GetMatchIDBean GetMatchIDBean = new GetMatchIDBean();

        return GetMatchIDBean.exec(GetUrlByPuuidBean.exec(puuid));
    }
}
