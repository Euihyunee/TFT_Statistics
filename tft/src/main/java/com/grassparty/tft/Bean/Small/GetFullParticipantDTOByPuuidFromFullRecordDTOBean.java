package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DTO.FullDTO.RecordParticipantDTO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import org.springframework.stereotype.Component;

@Component
public class GetFullParticipantDTOByPuuidFromFullRecordDTOBean {
    public RecordParticipantDTO exec(RecordDTO recordDTO, String puuid){
        // 로직
        int index =0;
        for(String id : recordDTO.getParticipantsPuuid()){
            if(puuid.equals(id)){
                break;
            }
            index++;
        }
        return recordDTO.getParticipants()[index];
    }

}
