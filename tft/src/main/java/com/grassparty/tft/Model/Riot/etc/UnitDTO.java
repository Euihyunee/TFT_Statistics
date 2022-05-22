package com.grassparty.tft.Model.Riot.etc;

<<<<<<< HEAD
import lombok.Data;

@Data
=======
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
>>>>>>> 600b34629d333935af687cd498800df2bc48d077
public class UnitDTO {
    int[] items;
    String character_id;
    // String chosen; // ??
    String name;
    int rarity;
    int tier;


}
