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
import com.grassparty.tft.Model.Riot.etc.ParticipantDto;
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
            fullRecordDTOs.add(fullRecordDTO);
        }

        return fullRecordDTOs;
    }

    public FullRecordDTO GetFullRecordFromMatchDTO(MatchDto matchDto){
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
                    fullUnitDTOS[j] = GetFullUnitDTOFromUnitDto(matchDto.getInfo().getParticipants()[i].getUnits()[j]);
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

    public FullUnitDTO GetFullUnitDTOFromUnitDto(UnitDto unitDto){
        FullUnitDTO fullUnitDTO = new FullUnitDTO();

        fullUnitDTO.setItems(unitDto.getItems());
        fullUnitDTO.setCharacter_id(unitDto.getCharacter_id());
        fullUnitDTO.setItemNames(unitDto.getItemNames());
        fullUnitDTO.setRarity(unitDto.getRarity());
        fullUnitDTO.setTier(unitDto.getTier());

        return fullUnitDTO;
    }

    public MetaRecordDTO GetMetaRecordFromFullRecord(FullRecordDTO fullRecordDTO, String puuid){
        // FullRecordDTO -> MetaRecordDTO 로 변환
        MetaRecordDTO metaRecordDTO = new MetaRecordDTO();

        FullParticipantDTO fullParticipantDTO = GetFullParticipantDTOByPuuidFromFullRecordDTO(fullRecordDTO, puuid);

        metaRecordDTO.setPlacement(fullParticipantDTO.getPlacement());
        metaRecordDTO.setTime_eliminated(fullParticipantDTO.getTime_eliminated());
        metaRecordDTO.setTraits(fullParticipantDTO.getTraits());
        metaRecordDTO.setAugments(fullParticipantDTO.getAugments());
        metaRecordDTO.setUnitDTO(fullParticipantDTO.getUnits());
        //metaRecordDTO.setParticipantName();

        return metaRecordDTO;
    }

    public FullParticipantDTO GetFullParticipantDTOByPuuidFromFullRecordDTO(FullRecordDTO fullRecordDTO, String puuid){
        int index =0;
        for(String id : fullRecordDTO.getParticipantsPuuid()){
            if(puuid.equals(id)){
                break;
            }
            index++;
        }
        return fullRecordDTO.getParticipants()[index];

    }

}
