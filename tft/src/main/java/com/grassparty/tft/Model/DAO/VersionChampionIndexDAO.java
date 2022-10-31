package com.grassparty.tft.Model.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="version_champion_index")
public class VersionChampionIndexDAO {

    @Id
    private Long version_champion_id;

    // 외래키
    @Column
    private int season_id;

    // 외래키
    @Column
    private int champion_id;

    @Column
    private int id;
}
