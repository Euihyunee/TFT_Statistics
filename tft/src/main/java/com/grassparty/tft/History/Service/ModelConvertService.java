package com.grassparty.tft.History.Service;

import com.grassparty.tft.Bean.GetFullRecordFromMatchDTOBean;
import com.grassparty.tft.Bean.GetFullUnitDTOFromUnitDtoBean;
import com.grassparty.tft.Model.DTO.FullRecordDTO;
import com.grassparty.tft.Model.DTO.FullRecordDTOs;
import com.grassparty.tft.Model.DTO.MetaRecordDTO;
import com.grassparty.tft.Model.DTO.FullDTO.FullParticipantDTO;
import com.grassparty.tft.Model.DTO.FullDTO.FullUnitDTO;
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
            fullRecordDTOs.add(fullRecordDTO);
        }

        return fullRecordDTOs;
    }

    public FullRecordDTO GetFullRecordFromMatchDTO(MatchDto matchDto){
        GetFullRecordFromMatchDTOBean GetFullRecordFromMatchDTOBean = new GetFullRecordFromMatchDTOBean();

        return GetFullRecordFromMatchDTOBean.exec(matchDto);
    }

    public FullUnitDTO GetFullUnitDTOFromUnitDto(UnitDto unitDto){
        GetFullUnitDTOFromUnitDtoBean GetFullUnitDTOFromUnitDtoBean = new GetFullUnitDTOFromUnitDtoBean();

        return GetFullUnitDTOFromUnitDtoBean.exec(unitDto);
    }

    public MetaRecordDTO[] GetMetaRecordsFromFullRecords(FullRecordDTO[] fullRecordDTOs, String puuid){
        MetaRecordDTO[] metaRecordDTOS = new MetaRecordDTO[10];
        for(int i=0; i<fullRecordDTOs.length; i++){
            metaRecordDTOS[i] = GetMetaRecordFromFullRecord(fullRecordDTOs[i], puuid);

        }

        return metaRecordDTOS;
    }

    public MetaRecordDTO GetMetaRecordFromFullRecord(FullRecordDTO fullRecordDTO, String puuid){
        // FullRecordDTO -> MetaRecordDTO 로 변환
        MetaRecordDTO metaRecordDTO = new MetaRecordDTO();

        FullParticipantDTO fullParticipantDTO = GetFullParticipantDTOByPuuidFromFullRecordDTO(fullRecordDTO, puuid);

        metaRecordDTO.setMatch_id(fullRecordDTO.getMatch_id());
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
