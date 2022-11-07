package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DTO.RecordDTO;
import org.springframework.stereotype.Component;

@Component
public class GetGameDatetimeBean {

    // RecordDTO에서 GameDatetime 가져오는 빈
    public Long exec(RecordDTO recordDTO){
        return recordDTO.getGame_datetime();
    }
}
