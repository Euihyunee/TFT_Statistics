package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DTO.RecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MappingChampionIndexBean {
    @Autowired
    GetChampionIdListBean getChampionIdListBean;
    public void exec(RecordDTO recordDTO){
        // 12.20.448.8884
        // 12 seasonVersion
        String seasonVersion = recordDTO.getGame_version();

        System.out.println("레코드 : " + recordDTO);
        // 챔피언 이름 뽑기
        List<String> chanpionIdList = getChampionIdListBean.exec(recordDTO);
        System.out.println("챔피언 id : " + chanpionIdList);


    }
}

