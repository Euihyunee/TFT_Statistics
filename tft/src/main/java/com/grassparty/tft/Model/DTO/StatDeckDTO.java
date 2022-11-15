package com.grassparty.tft.Model.DTO;

import com.grassparty.tft.Model.DTO.FullDTO.RecordUnitDTO;
import lombok.Data;

import java.util.List;

@Data
public class StatDeckDTO {
    String version;
    String deckName;
    float averagePlacement;
    float frequency;
    String tier; // 덱 티어
    // 유닛
    List<RecordUnitDTO> unit;

}
