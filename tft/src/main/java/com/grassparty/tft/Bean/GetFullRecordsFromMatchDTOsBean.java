package com.grassparty.tft.Bean;

import com.grassparty.tft.Model.DTO.FullRecordDTO;
import com.grassparty.tft.Model.DTO.FullRecordDTOs;
import com.grassparty.tft.Model.Riot.MatchDtos;

public class GetFullRecordsFromMatchDTOsBean {
    public FullRecordDTOs exec(MatchDtos matchDtos){
        GetFullRecordFromMatchDTOBean GetFullRecordFromMatchDTOBean = new GetFullRecordFromMatchDTOBean();
        // 로직
        FullRecordDTO fullRecordDTO;
        FullRecordDTOs fullRecordDTOs = new FullRecordDTOs();
        int count =0;
        for(int i =0; i < matchDtos.getMatchDtos().toArray().length; i++){
            fullRecordDTO = GetFullRecordFromMatchDTOBean.exec(matchDtos.getMatchDtos().get(i));
            fullRecordDTOs.add(fullRecordDTO);
        }

        return fullRecordDTOs;
    }
}
