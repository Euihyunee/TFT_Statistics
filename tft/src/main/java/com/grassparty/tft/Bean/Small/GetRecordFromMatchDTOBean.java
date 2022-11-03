package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DTO.FullDTO.RecordParticipantDTO;
import com.grassparty.tft.Model.DTO.FullDTO.RecordUnitDTO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Model.Riot.MatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetRecordFromMatchDTOBean {

    @Autowired
    GetRecordUnitDTOFromUnitDtoBean getRecordUnitDTOFromUnitDtoBean;

    public RecordDTO exec(MatchDto matchDto){
        // 로직
        // Riot DTO인 MatchDTO -> FullRecordDTO 로 변환
        RecordParticipantDTO recordParticipantDTO;
        RecordParticipantDTO[] recordParticipantDTOS = new RecordParticipantDTO[8];
        RecordDTO recordDTO = new RecordDTO();


        recordDTO.setGame_datetime(matchDto.getInfo().getGame_datetime());

        // version parsing 후 recordDTO.setGame_version
        String version_parsing = matchDto.getInfo().getGame_version();
        String[] version = version_parsing.split(" ");
        recordDTO.setGame_version(version[1]);
        recordDTO.setMatch_id(matchDto.getMetadata().getMatch_id());
        recordDTO.setParticipantsPuuid(matchDto.getMetadata().getParticipants());
        recordDTO.setGame_length(matchDto.getInfo().getGame_length());

        int len = matchDto.getInfo().getParticipants().length;
        for(int i=0; i<len; i++){
            recordParticipantDTO = new RecordParticipantDTO();
            recordParticipantDTO.setAugments(matchDto.getInfo().getParticipants()[i].getAugments());
            recordParticipantDTO.setGold_left(matchDto.getInfo().getParticipants()[i].getGold_left());
            recordParticipantDTO.setCompanion(matchDto.getInfo().getParticipants()[i].getCompanion());
            recordParticipantDTO.setLevel(matchDto.getInfo().getParticipants()[i].getLevel());
            recordParticipantDTO.setLast_round(matchDto.getInfo().getParticipants()[i].getLast_round());
            recordParticipantDTO.setPlacement(matchDto.getInfo().getParticipants()[i].getPlacement());
            // fullRecordDTO.getParticipants()[i].setPuuid(matchDto.getInfo().getParticipants()[i].getPuuid());
            recordParticipantDTO.setTime_eliminated(matchDto.getInfo().getParticipants()[i].getTime_eliminated());
            recordParticipantDTO.setTraits(matchDto.getInfo().getParticipants()[i].getTraits());


            int UnitLen = matchDto.getInfo().getParticipants()[i].getUnits().length;
            RecordUnitDTO[] fullUnitDTOS = new RecordUnitDTO[12];

            for(int j=0; j<UnitLen; j++){
                try{
                    fullUnitDTOS[j] = getRecordUnitDTOFromUnitDtoBean.exec(matchDto.getInfo().getParticipants()[i].getUnits()[j]);
                }
                catch (NullPointerException e){

                }
            }
            recordParticipantDTO.setUnits(fullUnitDTOS);
            recordParticipantDTOS[i]= recordParticipantDTO;

        }
        recordDTO.setParticipants(recordParticipantDTOS);

        return recordDTO;
    }
}
