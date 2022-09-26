package com.grassparty.tft.History.Service;

import com.grassparty.tft.Bean.*;
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
        GetFullRecordsFromMatchDTOsBean GetFullRecordsFromMatchDTOsBean = new GetFullRecordsFromMatchDTOsBean();

        return GetFullRecordsFromMatchDTOsBean.exec(matchDtos);
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
        GetMetaRecordsFromFullRecordsBean GetMetaRecordsFromFullRecordsBean = new GetMetaRecordsFromFullRecordsBean();

        return GetMetaRecordsFromFullRecordsBean.exec(fullRecordDTOs, puuid);
    }

    public MetaRecordDTO GetMetaRecordFromFullRecord(FullRecordDTO fullRecordDTO, String puuid){
        GetMetaRecordFromFullRecordBean GetMetaRecordFromFullRecordBean = new GetMetaRecordFromFullRecordBean();

        return GetMetaRecordFromFullRecordBean.exec(fullRecordDTO, puuid);
    }

    public FullParticipantDTO GetFullParticipantDTOByPuuidFromFullRecordDTO(FullRecordDTO fullRecordDTO, String puuid){
        GetFullParticipantDTOByPuuidFromFullRecordDTOBean GetFullParticipantDTOByPuuidFromFullRecordDTOBean = new GetFullParticipantDTOByPuuidFromFullRecordDTOBean();

        return GetFullParticipantDTOByPuuidFromFullRecordDTOBean.exec(fullRecordDTO, puuid);
    }

}
