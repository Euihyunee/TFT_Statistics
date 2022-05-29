package com.grassparty.tft.Model.Riot.FullDTO;

import com.grassparty.tft.Model.Riot.etc.ParticipantDto;
import lombok.Data;

@Data
public class FullInfoDTO {
    // long game_datetime;
    float game_length;
    FullParticipantDTO[] participants;
}
