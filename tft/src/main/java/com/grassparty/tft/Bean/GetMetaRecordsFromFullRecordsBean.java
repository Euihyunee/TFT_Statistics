package com.grassparty.tft.Bean;

import com.grassparty.tft.Model.DTO.FullRecordDTO;
import com.grassparty.tft.Model.DTO.MetaRecordDTO;

public class GetMetaRecordsFromFullRecordsBean {
    public MetaRecordDTO[] exec(FullRecordDTO[] fullRecordDTOs, String puuid){
        GetMetaRecordFromFullRecordBean GetMetaRecordFromFullRecordBean = new GetMetaRecordFromFullRecordBean();
        // 로직
        MetaRecordDTO[] metaRecordDTOS = new MetaRecordDTO[10];
        for(int i=0; i<fullRecordDTOs.length; i++){
            metaRecordDTOS[i] = GetMetaRecordFromFullRecordBean.exec(fullRecordDTOs[i], puuid);

        }

        return metaRecordDTOS;

    }
}
