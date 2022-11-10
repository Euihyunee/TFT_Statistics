package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DTO.FullDTO.RecordParticipantDTO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetRecordParticipantDTOListBean {

    public List<RecordParticipantDTO> exec(RecordDTO recordDTO) {
        List<RecordParticipantDTO> recordParticipantDTOList = new ArrayList<>();
        for (RecordParticipantDTO participant : recordDTO.getParticipants()) {
            recordParticipantDTOList.add(participant);
        }
        return recordParticipantDTOList;
    }
}
