package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Model.DTO.MetaRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMetaRecordsFromFullRecordsBean {

    @Autowired
    GetMetaRecordFromFullRecordBean getMetaRecordFromFullRecordBean;

    public MetaRecordDTO[] exec(RecordDTO[] recordDTOS, String puuid){
        // 로직
        MetaRecordDTO[] metaRecordDTOS = new MetaRecordDTO[10];
        for(int i = 0; i< recordDTOS.length; i++){
            metaRecordDTOS[i] = getMetaRecordFromFullRecordBean.exec(recordDTOS[i], puuid);

        }

        return metaRecordDTOS;

    }
}
