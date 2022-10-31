package com.grassparty.tft.Model.DTO.FullDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordUnitDTO {
    int[] items;
    String character_id;
    // String chosen; // ??
    String[] itemNames;
    // String name; 이름 제거

    int rarity;
    int tier;
}
