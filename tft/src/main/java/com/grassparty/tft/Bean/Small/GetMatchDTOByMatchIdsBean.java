package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Bean.GetMatchDTOBean;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.MatchDtos;
import com.grassparty.tft.Model.Riot.MatchID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMatchDTOByMatchIdsBean {

    @Autowired
    GetMatchDTOBean getMatchDTOBean;

    public MatchDtos exec(MatchID matchids){
        // 로직
        MatchDtos matchDtos = new MatchDtos();
        MatchDto matchDto;

        // 적제
        for(int i =0; i< matchids.getMatchid().length; i++){
            matchDto = getMatchDTOBean.exec(matchids.getMatchid()[i]);
            matchDtos.PushMatchDto(matchDto);
        }

        return matchDtos;
    }
}
