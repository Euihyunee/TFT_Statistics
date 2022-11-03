package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DTO.FullDTO.RecordUnitDTO;
import com.grassparty.tft.Model.Riot.etc.UnitDto;
import org.springframework.stereotype.Component;

@Component
public class GetRecordUnitDTOFromUnitDtoBean {


    public RecordUnitDTO exec(UnitDto unitDto){
        RecordUnitDTO fullUnitDTO = new RecordUnitDTO();

        fullUnitDTO.setItems(unitDto.getItems());
        fullUnitDTO.setCharacter_id(unitDto.getCharacter_id());
        fullUnitDTO.setItemNames(unitDto.getItemNames());
        fullUnitDTO.setRarity(unitDto.getRarity());
        fullUnitDTO.setTier(unitDto.getTier());

        return fullUnitDTO;
    }
}
