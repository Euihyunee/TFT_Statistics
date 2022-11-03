package com.grassparty.tft.Model.DAO;

import javax.persistence.*;

@Entity
@Table(name="version_champion_index")
public class VersionChampionIndexDAO {

    @Id @GeneratedValue
    private Long versionChampionId;

    // 외래키
    @Column
    private Long gameVersionId;

    // 외래키
    @Column
    private int championId;

    @Column
    private int index;
}
