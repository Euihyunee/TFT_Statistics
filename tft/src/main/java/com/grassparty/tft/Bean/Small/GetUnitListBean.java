package com.grassparty.tft.Bean.Small;


import com.grassparty.tft.Model.DTO.FullDTO.RecordParticipantDTO;
import com.grassparty.tft.Model.DTO.FullDTO.RecordUnitDTO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetUnitListBean {
    public List<RecordUnitDTO[]> exec(RecordDTO recordDTO) {
        List<RecordUnitDTO[]> unitDtoList = new ArrayList<>();
        for (RecordParticipantDTO recordParticipantDTO : recordDTO.getParticipants()) {
            if (recordParticipantDTO == null) {
                break;
            }
            unitDtoList.add(recordParticipantDTO.getUnits());
        }
        return unitDtoList;
    }
}
