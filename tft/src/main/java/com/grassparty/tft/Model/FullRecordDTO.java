package com.grassparty.tft.Model;

import com.grassparty.tft.Model.FullDTO.FullInfoDTO;
import com.grassparty.tft.Model.FullDTO.FullMetadataDTO;
import com.grassparty.tft.Model.FullDTO.FullParticipantDTO;
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
