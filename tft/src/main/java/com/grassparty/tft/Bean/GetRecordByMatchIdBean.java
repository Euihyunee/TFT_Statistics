package com.grassparty.tft.Bean;

import com.grassparty.tft.Bean.Small.GetFullRecordFromMatchDTOBean;
import com.grassparty.tft.Bean.Small.GetMatchDTOBean;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Model.Riot.MatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetRecordByMatchIdBean {

    @Autowired
    GetMatchDTOBean getMatchDTOBean;
    @Autowired
    GetFullRecordFromMatchDTOBean getFullRecordFromMatchDTOBean;

    public RecordDTO exec(String matchid){
        // matchid 로 matchDTO 받기
        MatchDto matchDto = getMatchDTOBean.exec(matchid);

        // matchDTO를 FullRecordDTo로 변환
        RecordDTO recordDTO;
        recordDTO = getFullRecordFromMatchDTOBean.exec(matchDto);

        return recordDTO;
    }
}
