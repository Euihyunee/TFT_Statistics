package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Model.DTO.RecordDTOs;
import com.grassparty.tft.Model.Riot.MatchDtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetRecordsFromMatchDTOsBean {

    @Autowired
    GetRecordFromMatchDTOBean getRecordFromMatchDTOBean;

    public RecordDTOs exec(MatchDtos matchDtos){
        // 로직
        RecordDTO recordDTO;
        RecordDTOs recordDTOs = new RecordDTOs();
        int count =0;
        for(int i =0; i < matchDtos.getMatchDtos().toArray().length; i++){
            recordDTO = getRecordFromMatchDTOBean.exec(matchDtos.getMatchDtos().get(i));
            recordDTOs.add(recordDTO);
        }

        return recordDTOs;
    }
}
