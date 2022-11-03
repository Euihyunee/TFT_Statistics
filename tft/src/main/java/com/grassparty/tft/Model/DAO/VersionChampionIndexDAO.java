package com.grassparty.tft.Model.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="version_champion_index")
@Data
public class VersionChampionIndexDAO {

    @Id @GeneratedValue
    private Long versionChampionId;

    // 외래키
    @Column
    private int seasonVersion;

    // 외래키
    @Column
    private String championId;

    @Column
    private int orderIndex;
}
