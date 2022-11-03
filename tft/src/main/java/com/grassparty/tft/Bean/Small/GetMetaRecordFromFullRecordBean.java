package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DTO.FullDTO.RecordParticipantDTO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Model.DTO.MetaRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMetaRecordFromFullRecordBean {

    @Autowired
    GetParticipantDTOByPuuidFromRecordDTOBean getParticipantDTOByPuuidFromRecordDTOBean;

    public MetaRecordDTO exec(RecordDTO recordDTO, String puuid){
        // 로직
        // FullRecordDTO -> MetaRecordDTO 로 변환
        MetaRecordDTO metaRecordDTO = new MetaRecordDTO();

        RecordParticipantDTO recordParticipantDTO = getParticipantDTOByPuuidFromRecordDTOBean.exec(recordDTO, puuid);

        metaRecordDTO.setMatch_id(recordDTO.getMatch_id());
        metaRecordDTO.setPlacement(recordParticipantDTO.getPlacement());
        metaRecordDTO.setTime_eliminated(recordParticipantDTO.getTime_eliminated());
        metaRecordDTO.setTraits(recordParticipantDTO.getTraits());
        metaRecordDTO.setAugments(recordParticipantDTO.getAugments());
        metaRecordDTO.setUnitDTO(recordParticipantDTO.getUnits());
        //metaRecordDTO.setParticipantName();

        return metaRecordDTO;
    }
}
