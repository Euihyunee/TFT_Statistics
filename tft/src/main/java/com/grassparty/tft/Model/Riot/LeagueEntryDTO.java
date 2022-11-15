package com.grassparty.tft.Model.Riot;

import lombok.Data;

@Data
public class LeagueEntryDTO {
    String leagueId;
    String summonerId;
    String queueType;
    String ratedTier;
    int ratedRating;
    String tier;
    String rank;
    int leaguePoints;
    int wins;
    int losses;
    boolean hotStreak;
    boolean veteran;
    boolean freshBlood;
    boolean inactive;
}
