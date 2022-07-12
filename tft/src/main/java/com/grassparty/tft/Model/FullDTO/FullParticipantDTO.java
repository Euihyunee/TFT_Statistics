package com.grassparty.tft.Model.FullDTO;

import com.grassparty.tft.Model.Riot.etc.CompanionDto;
import com.grassparty.tft.Model.Riot.etc.TraitDto;
import lombok.Data;

@Data
public class FullParticipantDTO {
    String[] augments;
    CompanionDto companion;
    int gold_left;
    int last_round;
    int level;
    int placement;
    // int players_eliminated;
    String puuid;
    float time_eliminated;
    // int total_damage_to_players;
    TraitDto[] traits;
    FullUnitDTO[] units;
}
