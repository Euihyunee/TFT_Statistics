package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DTO.FullDTO.RecordParticipantDTO;
import com.grassparty.tft.Model.DTO.FullDTO.RecordUnitDTO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetChampionIdListBean {
    public List<String> exec(RecordDTO recordDTO) {
        List<String> championIdList = new ArrayList<>();
        for(RecordParticipantDTO recordParticipantDTO :recordDTO.getParticipants()){
            for(RecordUnitDTO recordUnitDTO:recordParticipantDTO.getUnits()){
                if(recordUnitDTO == null){
                    break;
                }
                System.out.println("챔피언 아이디 : " + recordUnitDTO.getCharacter_id());
                championIdList.add(recordUnitDTO.getCharacter_id());

            }
        }

        return championIdList;
    }

    public List<String> exec(RecordDTO record, int i) {
        List<String> championIdList = new ArrayList<>();

        RecordParticipantDTO recordParticipantDTO = record.getParticipants()[i];
        for(RecordUnitDTO recordUnitDTO:recordParticipantDTO.getUnits()){
            if(recordUnitDTO == null){
                break;
            }
            System.out.println("챔피언 아이디 : " + recordUnitDTO.getCharacter_id());
            championIdList.add(recordUnitDTO.getCharacter_id());

        }

        return championIdList;
    }
}
