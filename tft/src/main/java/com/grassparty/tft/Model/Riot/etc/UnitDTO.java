package com.grassparty.tft.Model.Riot.etc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UnitDTO {
    int[] items;
    String character_id;
    // String chosen; // ??
    String name;
    int rarity;
    int tier;


}
