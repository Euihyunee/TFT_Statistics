package com.grassparty.tft.Model.Riot.etc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitDto {
    int[] items;
    String character_id;
    // String chosen; // ??
    String[] itemNames;
    String name;

    int rarity;
    int tier;


}
