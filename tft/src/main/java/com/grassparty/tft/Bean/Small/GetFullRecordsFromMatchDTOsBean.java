package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DTO.FullRecordDTO;
import com.grassparty.tft.Model.DTO.FullRecordDTOs;
import com.grassparty.tft.Model.Riot.MatchDtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetFullRecordsFromMatchDTOsBean {

    @Autowired
    GetFullRecordFromMatchDTOBean getFullRecordFromMatchDTOBean;

    public FullRecordDTOs exec(MatchDtos matchDtos){
        // 로직
        FullRecordDTO fullRecordDTO;
        FullRecordDTOs fullRecordDTOs = new FullRecordDTOs();
        int count =0;
        for(int i =0; i < matchDtos.getMatchDtos().toArray().length; i++){
            fullRecordDTO = getFullRecordFromMatchDTOBean.exec(matchDtos.getMatchDtos().get(i));
            fullRecordDTOs.add(fullRecordDTO);
        }

        return fullRecordDTOs;
    }
}
