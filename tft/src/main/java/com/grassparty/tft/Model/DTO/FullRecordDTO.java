package com.grassparty.tft.Model.DTO;

import com.grassparty.tft.Model.DTO.FullDTO.FullParticipantDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullRecordDTO {
    float game_length;
    String match_id;
    String[] participantsPuuid; // 이름 변경
    FullParticipantDTO[] participants;
}
