package com.grassparty.tft.Model.DAO;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="stat_champion")
@Data
public class StatChampionDAO {

    @Id @GeneratedValue
    private Long id;

    // 외래키
    @Column
    private String championName;

    // 외래키
    @Column
    private Long versionId;


    @Column
    private Long count;

    @Column
    private Long placement;

    @Column
    private Long threeStarCount;

    @Column
    private Long threeStarPlacement;
}
