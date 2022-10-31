package com.grassparty.tft.Model.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stat_champion_deck_count")
public class StatChampionDeckCountDAO {

    @Id
    private Long id;

    // 외래키
    @Column
    private int seasion_id;

    // 외래키
    @Column
    private int update_id;

    @Column
    private Long total_deck_count;
}
