package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Bean.GetMatchDTOBean;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.MatchDtos;
import com.grassparty.tft.Model.Riot.MatchID;
import org.springframework.stereotype.Component;

@Component
public class GetMatchDTOByMatchIdsBean {
    public MatchDtos exec(MatchID matchids){
        GetMatchDTOBean GetMatchDTOBean = new GetMatchDTOBean();

        // 로직
        MatchDtos matchDtos = new MatchDtos();
        MatchDto matchDto;

        // 적제
        for(int i =0; i< matchids.getMatchid().length; i++){
            matchDto = GetMatchDTOBean.exec(matchids.getMatchid()[i]);
            matchDtos.PushMatchDto(matchDto);
        }

        return matchDtos;
    }
}
