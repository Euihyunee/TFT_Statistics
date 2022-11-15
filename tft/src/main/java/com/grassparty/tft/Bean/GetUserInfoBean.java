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
        UserInfoDTO userInfo = null;
        
        // 유저 이름으로 id 가져오기
        String summonerId;
        summonerId = getSummonerDTOByNameBean.exec(userName).getId();
        
        // id로 /tft/league/v1/entries/by-summoner/{summonerId} 요청하기
        LeagueEntryDTO leagueEntryDTO;
        leagueEntryDTO = getLeagueEntryBean.exec(summonerId);

        // leagueEntryDTO로 userinfoDTO로 변환
        userInfo = exec(leagueEntryDTO);

        return userInfo;
    }

    // 생성자 때문에 이 함수 지우면 위에 함수에 영향을 받음.
    public UserInfoDTO exec(LeagueEntryDTO leagueEntryDTO){
        UserInfoDTO userInfo = new UserInfoDTO();

        userInfo.setTier(leagueEntryDTO.getTier());
        userInfo.setTierDetail(leagueEntryDTO.getRank());
        userInfo.setLeaguePoint(leagueEntryDTO.getLeaguePoints());
        userInfo.setWin(leagueEntryDTO.getWins());
        userInfo.setLose(leagueEntryDTO.getLosses());

        return userInfo;
    }

}
