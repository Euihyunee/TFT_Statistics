package com.grassparty.tft.Bean;

import com.grassparty.tft.History.Repository.StatRepository;
import com.grassparty.tft.Model.DB.StatTable;
import com.grassparty.tft.Model.DTO.FullDTO.FullParticipantDTO;
import com.grassparty.tft.Model.DTO.FullDTO.FullUnitDTO;
import com.grassparty.tft.Model.DTO.FullRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class SaveStatTableFromFullRecordDTOBean { // 더작게 ?
    @Autowired
    StatRepository statRepository;
    MappingStatTable MappingStatTable = new MappingStatTable();

    public void exec(FullRecordDTO fullRecordDTO){
        ArrayList<String> charaterName = new ArrayList<>();

        for(FullParticipantDTO fp : fullRecordDTO.getParticipants()){
            StatTable statTable = new StatTable();
            for(FullUnitDTO unit : fp.getUnits()){
                if(unit == null){
                    break;
                }
                charaterName.add(unit.getCharacter_id());
                // System.out.println(unit.getCharacter_id());
            }
            // 캐릭터 이름 맵핑
            System.out.println(charaterName);
            for(int i =0; i< charaterName.size(); i++){
                statTable = MappingStatTable.exec(statTable, charaterName.get(i));
            }
            // 등수 삽입
            statTable.setPlacement(fp.getPlacement());

            // valid = false
            statTable.setValid(false);

            // StatTable을 DB에 저장
            statRepository.save(statTable);

            // 초기화
            charaterName.clear();
        }
    }
}