package com.grassparty.tft.Model.DTO;

import lombok.Data;

// 덱 티어 리스트 DTO
@Data
public class StatisticDTO {
    // 덱 이름, 덱 평균 등수(place/count), 챔피언 이름
    private String deckName;
    private float placementRate;
    private String[] character_id;

}
