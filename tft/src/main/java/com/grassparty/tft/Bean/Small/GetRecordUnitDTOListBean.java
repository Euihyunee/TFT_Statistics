package com.grassparty.tft.Bean.Small;


import com.grassparty.tft.Model.DTO.FullDTO.RecordParticipantDTO;
import com.grassparty.tft.Model.DTO.FullDTO.RecordUnitDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetRecordUnitDTOListBean {
    public List<RecordUnitDTO> exec(RecordParticipantDTO recordParticipantDTO) {

        List<RecordUnitDTO> recordUnitDTOList = new ArrayList<>();
        for (RecordUnitDTO recordUnitDTO : recordParticipantDTO.getUnits()) {
            recordUnitDTOList.add(recordUnitDTO);
        }
        return recordUnitDTOList;
    }
}
