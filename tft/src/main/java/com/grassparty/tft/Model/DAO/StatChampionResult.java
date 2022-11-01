package com.grassparty.tft.Model.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stat_champion_result")
public class StatChampionResult {

    @Id
    private Long id;

    // 외래키
    @Column
    private int champion_id;

    // 외래키
    @Column
    private int season_id;

    // 외래키
    @Column
    private int update_id;

    @Column
    private double frequency;

    @Column
    private double average_placement;

    @Column
    private double three_star_frequency;

    @Column
    private double three_star_average_placement;
}
