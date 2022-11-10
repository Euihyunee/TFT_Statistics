package com.grassparty.tft.Model.DAO;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="stat_champion_result")
@Data
public class StatChampionResultDAO {

    @Id @GeneratedValue
    private Long id;

    // 외래키
    @Column
    private String championId;

    // 외래키
    @Column
    private Long versionId;

    @Column
    private double frequency;

    @Column
    private double averagePlacement;

    @Column
    private double threeStarFrequency;

    @Column
    private double threeStarAveragePlacement;
}
