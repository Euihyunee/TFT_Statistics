package com.grassparty.tft.Model.Riot;

// riot api DTO 받이
public class SummonerDTO {
    String accountId;
    int profileIconId;
    long revisionDate;
    String name;
    String id;
    String puuid;
    long summonerLevel;

    public String getPuuid(){
        return puuid;
    }
}
