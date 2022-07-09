package com.grassparty.tft.Model.Riot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// riot api DTO 받이
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SummonerDTO {
    String accountId;
    int profileIconId;
    long revisionDate;
    String name;
    String id;
    String puuid;
    long summonerLevel;
}
