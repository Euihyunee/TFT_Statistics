package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DTO.FullRecordDTO;
import com.grassparty.tft.Model.DTO.MetaRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMetaRecordsFromFullRecordsBean {

    @Autowired
    GetMetaRecordFromFullRecordBean getMetaRecordFromFullRecordBean;

    public MetaRecordDTO[] exec(FullRecordDTO[] fullRecordDTOs, String puuid){
        // 로직
        MetaRecordDTO[] metaRecordDTOS = new MetaRecordDTO[10];
        for(int i=0; i<fullRecordDTOs.length; i++){
            metaRecordDTOS[i] = getMetaRecordFromFullRecordBean.exec(fullRecordDTOs[i], puuid);

        }

        return metaRecordDTOS;

    }
}
