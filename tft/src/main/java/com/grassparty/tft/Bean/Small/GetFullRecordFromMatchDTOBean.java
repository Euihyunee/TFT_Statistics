package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DTO.FullDTO.FullParticipantDTO;
import com.grassparty.tft.Model.DTO.FullDTO.FullUnitDTO;
import com.grassparty.tft.Model.DTO.FullRecordDTO;
import com.grassparty.tft.Model.Riot.MatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetFullRecordFromMatchDTOBean {

    @Autowired
    GetFullUnitDTOFromUnitDtoBean getFullUnitDTOFromUnitDtoBean;

    public FullRecordDTO exec(MatchDto matchDto){
        // 로직
        // Riot DTO인 MatchDTO -> FullRecordDTO 로 변환
        FullParticipantDTO fullParticipantDTO;
        FullParticipantDTO[] fullParticipantDTOS = new FullParticipantDTO[8];
        FullRecordDTO fullRecordDTO = new FullRecordDTO();

        fullRecordDTO.setMatch_id(matchDto.getMetadata().getMatch_id());
        fullRecordDTO.setParticipantsPuuid(matchDto.getMetadata().getParticipants());
        fullRecordDTO.setGame_length(matchDto.getInfo().getGame_length());

        int len = matchDto.getInfo().getParticipants().length;
        for(int i=0; i<len; i++){
            fullParticipantDTO = new FullParticipantDTO();
            fullParticipantDTO.setAugments(matchDto.getInfo().getParticipants()[i].getAugments());
            fullParticipantDTO.setGold_left(matchDto.getInfo().getParticipants()[i].getGold_left());
            fullParticipantDTO.setCompanion(matchDto.getInfo().getParticipants()[i].getCompanion());
            fullParticipantDTO.setLevel(matchDto.getInfo().getParticipants()[i].getLevel());
            fullParticipantDTO.setLast_round(matchDto.getInfo().getParticipants()[i].getLast_round());
            fullParticipantDTO.setPlacement(matchDto.getInfo().getParticipants()[i].getPlacement());
            // fullRecordDTO.getParticipants()[i].setPuuid(matchDto.getInfo().getParticipants()[i].getPuuid());
            fullParticipantDTO.setTime_eliminated(matchDto.getInfo().getParticipants()[i].getTime_eliminated());
            fullParticipantDTO.setTraits(matchDto.getInfo().getParticipants()[i].getTraits());


            int UnitLen = matchDto.getInfo().getParticipants()[i].getUnits().length;
            FullUnitDTO[] fullUnitDTOS = new FullUnitDTO[12];

            for(int j=0; j<UnitLen; j++){
                try{
                    fullUnitDTOS[j] = getFullUnitDTOFromUnitDtoBean.exec(matchDto.getInfo().getParticipants()[i].getUnits()[j]);
                }
                catch (NullPointerException e){

                }
            }
            fullParticipantDTO.setUnits(fullUnitDTOS);
            fullParticipantDTOS[i]= fullParticipantDTO;

        }
        fullRecordDTO.setParticipants(fullParticipantDTOS);

        return fullRecordDTO;
    }
}
