package com.grassparty.tft.Model.DTO.FullDTO;

import lombok.Data;

@Data
public class RecordInfoDTO {
//    long game_datetime;
    float game_length;
//    String game_variation;
//    String game_version;
    RecordParticipantDTO[] participants;
//    String tft_game_type;
//    String tft_set_name;
//    int queue_id;
//    int tft_set_number;
}
