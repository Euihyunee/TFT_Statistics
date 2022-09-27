package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DTO.FullDTO.FullUnitDTO;
import com.grassparty.tft.Model.Riot.etc.UnitDto;
import org.springframework.stereotype.Component;

@Component
public class GetFullUnitDTOFromUnitDtoBean {
    public FullUnitDTO exec(UnitDto unitDto){
        FullUnitDTO fullUnitDTO = new FullUnitDTO();

        fullUnitDTO.setItems(unitDto.getItems());
        fullUnitDTO.setCharacter_id(unitDto.getCharacter_id());
        fullUnitDTO.setItemNames(unitDto.getItemNames());
        fullUnitDTO.setRarity(unitDto.getRarity());
        fullUnitDTO.setTier(unitDto.getTier());

        return fullUnitDTO;
    }
}
