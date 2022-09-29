package com.grassparty.tft.History.Service;

import com.grassparty.tft.Bean.*;
import com.grassparty.tft.Bean.GetMatchDTOBean;
import com.grassparty.tft.Bean.GetMatchIDBean;
import com.grassparty.tft.Model.DTO.FullRecordDTO;
import com.grassparty.tft.Model.DTO.MetaRecordDTO;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.MatchID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    @Autowired
    GetMatchHistoryByNameBean GetMatchHistoryByNameBean;
    @Autowired
    GetRecordByMatchIdBean GetRecordByMatchIdBean = new GetRecordByMatchIdBean();
    @Autowired
    GetMatchDTOBean GetMatchDTOBean = new GetMatchDTOBean();
    @Autowired
    GetMatchIDBean GetMatchIDBean = new GetMatchIDBean();


    // MetaRecordDTOs 닉네임으로 얻기
    public MetaRecordDTO[] GetMatchHistoryByName(String name){
        return GetMatchHistoryByNameBean.exec(name);
    }

    public FullRecordDTO GetRecordByMatchId(String matchid){
        return GetRecordByMatchIdBean.exec(matchid);
    }
}
