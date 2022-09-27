package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DTO.FullDTO.FullParticipantDTO;
import com.grassparty.tft.Model.DTO.FullRecordDTO;

public class GetFullParticipantDTOByPuuidFromFullRecordDTOBean {
    public FullParticipantDTO exec(FullRecordDTO fullRecordDTO, String puuid){
        // 로직
        int index =0;
        for(String id : fullRecordDTO.getParticipantsPuuid()){
            if(puuid.equals(id)){
                break;
            }
            index++;
        }
        return fullRecordDTO.getParticipants()[index];
    }

}
