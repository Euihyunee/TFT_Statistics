package com.grassparty.tft.Bean.Small.GetUrl;

import com.grassparty.tft.Model.Riot.SummonerDTO;
import com.grassparty.tft.Model.Riot.etc.ParticipantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class GetUrlBean implements GetUrl{
    @Autowired
    private Environment env;

    public String exec(String matchid){
        String api_query = "?api_key=";
        String site = "https://asia.api.riotgames.com/tft/match/v1/matches/";
        String url = site + matchid + api_query + env.getProperty("api_key");
        return url;
    }

    public String exec(SummonerDTO summonerDTO){
        String site = "https://asia.api.riotgames.com/tft/match/v1/matches/by-puuid/";
        String site_query = "/ids?start=0&count=10";
        String api_query = "&api_key=";
        String url = site + summonerDTO.getPuuid() + site_query + api_query + env.getProperty("api_key");
        return url;
    }

    public String exec(ParticipantDto participantDto){
        String site = "https://asia.api.riotgames.com/tft/match/v1/matches/by-puuid/";
        String site_query = "/ids?start=0&count=10";
        String api_query = "&api_key=";
        String url = site + participantDto.getPuuid() + site_query + api_query + env.getProperty("api_key");
        return url;
    }
}
