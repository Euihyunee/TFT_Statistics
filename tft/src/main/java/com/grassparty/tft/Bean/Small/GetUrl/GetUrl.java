package com.grassparty.tft.Bean.Small.GetUrl;

import com.grassparty.tft.Model.Riot.SummonerDTO;
import com.grassparty.tft.Model.Riot.etc.ParticipantDto;
import org.springframework.stereotype.Component;

@Component
public interface GetUrl {
    public String exec(String puuid);
    public String exec(SummonerDTO summonerDTO);
    public String exec(ParticipantDto participantDto);

}
