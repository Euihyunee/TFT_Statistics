package com.grassparty.tft.Service;

import com.grassparty.tft.Model.FullRecordDTO;
import com.grassparty.tft.Model.FullRecordDTOs;
import com.grassparty.tft.Model.MetaRecordDTO;
import com.grassparty.tft.Model.FullDTO.FullInfoDTO;
import com.grassparty.tft.Model.FullDTO.FullMetadataDTO;
import com.grassparty.tft.Model.FullDTO.FullParticipantDTO;
import com.grassparty.tft.Model.FullDTO.FullUnitDTO;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.MatchDtos;
import com.grassparty.tft.Model.Riot.etc.UnitDto;
import org.springframework.stereotype.Service;


@Service
public class ModelConvertService {

    public FullRecordDTOs GetFullRecordsFromMatchDTOs(MatchDtos matchDtos){
        FullRecordDTO fullRecordDTO;
        FullRecordDTOs fullRecordDTOs = new FullRecordDTOs();
        int count =0;
        for(int i =0; i < matchDtos.getMatchDtos().toArray().length; i++){
            fullRecordDTO = GetFullRecordFromMatchDTO(matchDtos.getMatchDtos().get(i));
            count = fullRecordDTOs.getFullRecordDTOs().length;
            fullRecordDTOs.getFullRecordDTOs()[count] = fullRecordDTO;
        }
        System.out.println("이거 실행봐나");

        return fullRecordDTOs;
    }

    public FullRecordDTO GetFullRecordFromMatchDTO(MatchDto matchDto){
        // Riot DTO인 MatchDTO -> FullRecordDTO 로 변환
        FullParticipantDTO fullParticipantDTO = new FullParticipantDTO();
        FullParticipantDTO[] fullParticipantDTOS = new FullParticipantDTO[8];
        FullRecordDTO fullRecordDTO = new FullRecordDTO();

        fullRecordDTO.setMatch_id(matchDto.getMetadata().getMatch_id());
        fullRecordDTO.setParticipantsPuuid(matchDto.getMetadata().getParticipants());
        fullRecordDTO.setGame_length(matchDto.getInfo().getGame_length());

        int len = matchDto.getInfo().getParticipants().length;
        int i,j;
        for(i=0; i<len; i++){
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
            for(j=0; j<UnitLen; j++){
                if(matchDto.getInfo().getParticipants()[i].getUnits()[j].getItems()!= null){
                    fullParticipantDTO.getUnits()[j].setItems(matchDto.getInfo().getParticipants()[i].getUnits()[j].getItems());
                }
                if(matchDto.getInfo().getParticipants()[i].getUnits()[j].getCharacter_id()!= null){
                    fullParticipantDTO.getUnits()[j].setCharacter_id(matchDto.getInfo().getParticipants()[i].getUnits()[j].getCharacter_id());
                }
                if(matchDto.getInfo().getParticipants()[i].getUnits()[j].getItemNames()!= null){
                    fullParticipantDTO.getUnits()[j].setItemNames(matchDto.getInfo().getParticipants()[i].getUnits()[j].getItemNames());
                }
                if(matchDto.getInfo().getParticipants()[i].getUnits()[j].getItemNames() != null){
                    fullParticipantDTO.getUnits()[j].setItemNames(matchDto.getInfo().getParticipants()[i].getUnits()[j].getItemNames());
                }
                if(matchDto.getInfo().getParticipants()[i].getUnits()[j].getTier() != 0){
                    fullParticipantDTO.getUnits()[j].setTier(matchDto.getInfo().getParticipants()[i].getUnits()[j].getTier());
                }

            }
            fullParticipantDTOS[i]= fullParticipantDTO;

        }
        fullRecordDTO.setParticipants(fullParticipantDTOS);

        return fullRecordDTO;
    }

    public MetaRecordDTO GetMetaRecordFromFullRecord(FullRecordDTO fullRecordDTO, String puuid){
        // FullRecordDTO -> MetaRecordDTO 로 변환

        return null;
    }

}
