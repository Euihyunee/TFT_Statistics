package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DTO.FullDTO.FullParticipantDTO;
import com.grassparty.tft.Model.DTO.FullRecordDTO;
import com.grassparty.tft.Model.DTO.MetaRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMetaRecordFromFullRecordBean {

    @Autowired
    GetFullParticipantDTOByPuuidFromFullRecordDTOBean GetFullParticipantDTOByPuuidFromFullRecordDTOBean;

    public MetaRecordDTO exec(FullRecordDTO fullRecordDTO, String puuid){
        // 로직
        // FullRecordDTO -> MetaRecordDTO 로 변환
        MetaRecordDTO metaRecordDTO = new MetaRecordDTO();

        FullParticipantDTO fullParticipantDTO = GetFullParticipantDTOByPuuidFromFullRecordDTOBean.exec(fullRecordDTO, puuid);

        metaRecordDTO.setMatch_id(fullRecordDTO.getMatch_id());
        metaRecordDTO.setPlacement(fullParticipantDTO.getPlacement());
        metaRecordDTO.setTime_eliminated(fullParticipantDTO.getTime_eliminated());
        metaRecordDTO.setTraits(fullParticipantDTO.getTraits());
        metaRecordDTO.setAugments(fullParticipantDTO.getAugments());
        metaRecordDTO.setUnitDTO(fullParticipantDTO.getUnits());
        //metaRecordDTO.setParticipantName();

        return metaRecordDTO;
    }
}
