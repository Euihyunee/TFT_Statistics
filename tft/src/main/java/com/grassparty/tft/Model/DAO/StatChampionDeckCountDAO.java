package com.grassparty.tft.Model.DAO;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="stat_champion_deck_count")
@Data
public class StatChampionDeckCountDAO {

    @Id @GeneratedValue
    private Long id;

    // 외래키
    @Column
    private Long versionId;

    @Column
    private Long totalDeckCount;
}
