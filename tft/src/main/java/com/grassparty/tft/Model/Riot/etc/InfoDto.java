package com.grassparty.tft.Model.Riot.etc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoDto {
    long game_datetime;
    float game_length;
    String game_variation;
    String game_version;
    ParticipantDto[] participants;
    String tft_game_type;
    String tft_set_core_name;
    int queue_id;
    int tft_set_number;
}
