package com.grassparty.tft.Model.DTO;

import com.grassparty.tft.Model.DTO.FullDTO.RecordParticipantDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordDTO {

    // String game_datetime 추가
    // String game_version  추가 Bean만들고 사용하는 곳 수정 예정

    float game_length;
    String match_id;
    String[] participantsPuuid; // 이름 변경
    RecordParticipantDTO[] participants;
}
