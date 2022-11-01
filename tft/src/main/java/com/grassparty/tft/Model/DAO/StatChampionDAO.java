package com.grassparty.tft.Model.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stat_champion")
public class StatChampionDAO {

    @Id
    private Long id;

    // 외래키
    @Column
    private int champion_id;

    // 외래키
    @Column
    private int version_id;

    @Column
    private String current_date;

    @Column
    private Long count;

}
