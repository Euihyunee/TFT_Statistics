package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Repository.StatRepository;
import com.grassparty.tft.Model.DAO.StatDeckDAO;
import com.grassparty.tft.Model.DTO.FullDTO.FullParticipantDTO;
import com.grassparty.tft.Model.DTO.FullDTO.RecordUnitDTO;
import com.grassparty.tft.Model.DTO.FullRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SaveStatTableFromFullRecordDTOBean { // 더작게 ?
    @Autowired
    StatRepository statRepository;
    @Autowired
    MappingStatTableBean mappingStatTableBean;

    public void exec(FullRecordDTO fullRecordDTO){
        ArrayList<String> charaterName = new ArrayList<>();

        for(FullParticipantDTO fp : fullRecordDTO.getParticipants()){
            StatDeckDAO statDeckDAO = new StatDeckDAO();
            for(RecordUnitDTO unit : fp.getUnits()){
                if(unit == null){
                    break;
                }
                charaterName.add(unit.getCharacter_id());
                // System.out.println(unit.getCharacter_id());
            }
            // 캐릭터 이름 맵핑
            System.out.println(charaterName);
            for(int i =0; i< charaterName.size(); i++){
                statDeckDAO = mappingStatTableBean.exec(statDeckDAO, charaterName.get(i));
            }
            // 등수 삽입
            statDeckDAO.setPlacement(fp.getPlacement());

            // valid = false
            statDeckDAO.setValid(false);

            // StatTable을 DB에 저장
            statRepository.save(statDeckDAO);

            // 초기화
            charaterName.clear();
        }
    }
}
