package com.grassparty.tft.History.Service;

import com.grassparty.tft.Bean.*;
import com.grassparty.tft.Bean.Small.GetMatchDTOBean;
import com.grassparty.tft.Bean.Small.GetMatchIDBean;
import com.grassparty.tft.Bean.Small.GetUrlByMatchIdBean;
import com.grassparty.tft.Bean.Small.GetUrlByPuuidBean;
import com.grassparty.tft.Model.DTO.FullRecordDTO;
import com.grassparty.tft.Model.DTO.MetaRecordDTO;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.MatchID;
import org.springframework.stereotype.Service;

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
