package com.grassparty.tft.Bean;

import org.springframework.stereotype.Component;

@Component
public class GetStatChampionResultDAOBean {

    /*
    champion_id : StatChampion 테이블에서 가져옴
    version_id : StatChampion 테이블에서 가져옴
    frequency = count / total_deck_count (stat_champion_deck_count 테이블)
    average_placement = placement / total_deck_count (stat_champion_deck_count 테이블)
    three_star_frequency = three_star_count / total_deck_count (stat_champion_deck_count 테이블)
    three_star_average_placement = three_star_placement / total_deck_count (stat_champion_deck_count 테이블)
     */
}
