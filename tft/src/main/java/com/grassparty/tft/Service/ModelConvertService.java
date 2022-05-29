package com.grassparty.tft.Service;

import com.grassparty.tft.Model.FullRecordDTO;
import com.grassparty.tft.Model.MetaRecordDTO;
import com.grassparty.tft.Model.Riot.FullDTO.FullParticipantDTO;
import com.grassparty.tft.Model.Riot.MatchDto;
import com.grassparty.tft.Model.Riot.etc.InfoDto;
import com.grassparty.tft.Model.Riot.etc.ParticipantDto;
import org.springframework.stereotype.Service;


@Service
public class ModelConvertService {

    public FullRecordDTO GetFullRecordFromMatchDTO(MatchDto matchDto){
        // Riot DTO인 MatchDTO -> FullRecordDTO 로 변환
        FullRecordDTO fullRecordDTO = new FullRecordDTO();

        fullRecordDTO.getMetadata().setMatch_id(matchDto.getMetadata().getMatch_id());
        fullRecordDTO.getMetadata().setParticipants(matchDto.getMetadata().getParticipants());

        fullRecordDTO.getInfo().setGame_length(matchDto.getInfo().getGame_length());
        int len = matchDto.getInfo().getParticipants().length;
        int i,j;
        for(i=0; i<len; i++){
            fullRecordDTO.getInfo().getParticipants()[i].setAugments(matchDto.getInfo().getParticipants()[i].getAugments());
            fullRecordDTO.getInfo().getParticipants()[i].setGold_left(matchDto.getInfo().getParticipants()[i].getGold_left());
            fullRecordDTO.getInfo().getParticipants()[i].setCompanion(matchDto.getInfo().getParticipants()[i].getCompanion());
            fullRecordDTO.getInfo().getParticipants()[i].setLevel(matchDto.getInfo().getParticipants()[i].getLevel());
            fullRecordDTO.getInfo().getParticipants()[i].setLast_round(matchDto.getInfo().getParticipants()[i].getLast_round());
            fullRecordDTO.getInfo().getParticipants()[i].setPlacement(matchDto.getInfo().getParticipants()[i].getPlacement());
            fullRecordDTO.getInfo().getParticipants()[i].setPuuid(matchDto.getInfo().getParticipants()[i].getPuuid());
            fullRecordDTO.getInfo().getParticipants()[i].setTime_eliminated(matchDto.getInfo().getParticipants()[i].getTime_eliminated());
            fullRecordDTO.getInfo().getParticipants()[i].setTraits(matchDto.getInfo().getParticipants()[i].getTraits());

            fullRecordDTO.getInfo().getParticipants()[i].getUnits()[i].setCharacter_id(matchDto.getInfo().getParticipants()[i].getUnits()[i].getCharacter_id());
            fullRecordDTO.getInfo().getParticipants()[i].getUnits()[i].setItemNames(matchDto.getInfo().getParticipants()[i].getUnits()[i].getItemNames());
            fullRecordDTO.getInfo().getParticipants()[i].getUnits()[i].setItems(matchDto.getInfo().getParticipants()[i].getUnits()[i].getItems());
            fullRecordDTO.getInfo().getParticipants()[i].getUnits()[i].setRarity(matchDto.getInfo().getParticipants()[i].getUnits()[i].getRarity());
            fullRecordDTO.getInfo().getParticipants()[i].getUnits()[i].setTier(matchDto.getInfo().getParticipants()[i].getUnits()[i].getTier());
        }
        return fullRecordDTO;
    }

    public MetaRecordDTO GetMetaRecordFromFullRecord(FullRecordDTO fullRecordDTO, String puuid){
        // FullRecordDTO -> MetaRecordDTO 로 변환

        return null;
    }

}