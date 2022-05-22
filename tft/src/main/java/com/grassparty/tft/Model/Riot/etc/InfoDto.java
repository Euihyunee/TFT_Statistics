package com.grassparty.tft.Model.Riot.etc;

import lombok.Data;

@Data
public class InfoDto {
    long game_dateTime;
    float game_length;
    String game_variation;
    String game_version;
    ParticipantDto[] participants;
    int queue_id;
    int tft_set_number;
}
