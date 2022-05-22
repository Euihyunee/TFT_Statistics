package com.grassparty.tft.Model.Riot.etc;

import lombok.Data;

@Data
public class ParticipantDto {
    CompanionDto companion;
    int gold_left;
    int last_round;
    int level;
    int placement;
    int players_eliminated;
    String puuid;
    float time_eliminated;
    int total_damage_to_players;
    TraitDto[] traits;
    UnitDto[] units;
}
