package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DTO.FullDTO.RecordParticipantDTO;
import com.grassparty.tft.Model.DTO.FullDTO.RecordUnitDTO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class GetChampionIdMapBean {
    public HashMap<Integer, List<String>> exec(RecordDTO recordDTO) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        int index=0;

        for(RecordParticipantDTO recordParticipantDTO :recordDTO.getParticipants()){
            List<String> championIdList = new ArrayList<>();
            for(RecordUnitDTO recordUnitDTO:recordParticipantDTO.getUnits()){
                if(recordUnitDTO == null){
                    break;
                }

                championIdList.add(recordUnitDTO.getCharacter_id());
            }

            map.put(index++, championIdList);
        }
        System.out.println("덱 구분 저장된 map : " + map);

        return map;
    }
}
