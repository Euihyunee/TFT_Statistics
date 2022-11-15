package com.grassparty.tft.Bean;

import com.grassparty.tft.Bean.Small.GetLeagueEntryBean;
import com.grassparty.tft.Bean.Small.GetSummonerDTOByNameBean;
import com.grassparty.tft.Model.DTO.UserInfoDTO;
import com.grassparty.tft.Model.Riot.LeagueEntryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserInfoBean {
    @Autowired
    GetLeagueEntryBean getLeagueEntryBean;
    @Autowired
    GetSummonerDTOByNameBean getSummonerDTOByNameBean;
    public UserInfoDTO exec(String userName){
        UserInfoDTO userInfo = new UserInfoDTO();
        
        // 유저 이름으로 id 가져오기
        String summonerId;
        summonerId = getSummonerDTOByNameBean.exec(userName).getId();
        
        // id로 /tft/league/v1/entries/by-summoner/{summonerId} 요청하기
        LeagueEntryDTO leagueEntryDTO;
        leagueEntryDTO = getLeagueEntryBean.exec(summonerId);



        return null;
    }

    public UserInfoDTO exec(LeagueEntryDTO leagueEntryDTO){
        return null;
    }

}
