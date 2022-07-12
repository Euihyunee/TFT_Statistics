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
        FullRecordDTO fullRecordDTO = new FullRecordDTO();
        FullRecordDTOs fullRecordDTOs = new FullRecordDTOs();
        int count;
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

        FullInfoDTO fullInfoDTO = new FullInfoDTO();
        FullMetadataDTO fullMetadataDTO = new FullMetadataDTO();

        FullRecordDTO fullRecordDTO = new FullRecordDTO(fullInfoDTO, fullMetadataDTO);

        fullRecordDTO.getMetadata().setMatch_id(matchDto.getMetadata().getMatch_id());
        fullRecordDTO.getMetadata().setParticipants(matchDto.getMetadata().getParticipants());

        fullRecordDTO.getInfo().setGame_length(matchDto.getInfo().getGame_length());
        int len = matchDto.getInfo().getParticipants().length;
        int i,j;
        for(i=0; i<=len-1; i++){
            fullRecordDTO.getInfo().getParticipants()[i].setAugments(matchDto.getInfo().getParticipants()[i].getAugments());
            fullRecordDTO.getInfo().getParticipants()[i].setGold_left(matchDto.getInfo().getParticipants()[i].getGold_left());
            fullRecordDTO.getInfo().getParticipants()[i].setCompanion(matchDto.getInfo().getParticipants()[i].getCompanion());
            fullRecordDTO.getInfo().getParticipants()[i].setLevel(matchDto.getInfo().getParticipants()[i].getLevel());
            fullRecordDTO.getInfo().getParticipants()[i].setLast_round(matchDto.getInfo().getParticipants()[i].getLast_round());
            fullRecordDTO.getInfo().getParticipants()[i].setPlacement(matchDto.getInfo().getParticipants()[i].getPlacement());
            fullRecordDTO.getInfo().getParticipants()[i].setPuuid(matchDto.getInfo().getParticipants()[i].getPuuid());
            fullRecordDTO.getInfo().getParticipants()[i].setTime_eliminated(matchDto.getInfo().getParticipants()[i].getTime_eliminated());
            fullRecordDTO.getInfo().getParticipants()[i].setTraits(matchDto.getInfo().getParticipants()[i].getTraits());
            int UnitLen = matchDto.getInfo().getParticipants()[i].getUnits().length;
            for(j=0;j<=UnitLen-1;j++){
                fullRecordDTO.getInfo().getParticipants()[i].getUnits()[i].setCharacter_id(matchDto.getInfo().getParticipants()[i].getUnits()[i].getCharacter_id());
                fullRecordDTO.getInfo().getParticipants()[i].getUnits()[i].setItemNames(matchDto.getInfo().getParticipants()[i].getUnits()[i].getItemNames());
                fullRecordDTO.getInfo().getParticipants()[i].getUnits()[i].setItems(matchDto.getInfo().getParticipants()[i].getUnits()[i].getItems());
                fullRecordDTO.getInfo().getParticipants()[i].getUnits()[i].setRarity(matchDto.getInfo().getParticipants()[i].getUnits()[i].getRarity());
                fullRecordDTO.getInfo().getParticipants()[i].getUnits()[i].setTier(matchDto.getInfo().getParticipants()[i].getUnits()[i].getTier());
            }
        }
        return fullRecordDTO;
    }

    public FullRecordDTO M_GetFullRecordFromMatchDTO(MatchDto matchDto){
        // 예시 (getter, setter를 사용하지 말고 생성자로 만드는 방식)
        UnitDto sampleUnitDto = matchDto.getInfo().getParticipants()[0].getUnits()[0];
        FullUnitDTO fullUnitDTO = new FullUnitDTO(sampleUnitDto.getItems(), sampleUnitDto.getCharacter_id(), sampleUnitDto.getItemNames(), sampleUnitDto.getRarity(), sampleUnitDto.getTier());

        return null;
    }

    public MetaRecordDTO GetMetaRecordFromFullRecord(FullRecordDTO fullRecordDTO, String puuid){
        // FullRecordDTO -> MetaRecordDTO 로 변환

        return null;
    }

}
