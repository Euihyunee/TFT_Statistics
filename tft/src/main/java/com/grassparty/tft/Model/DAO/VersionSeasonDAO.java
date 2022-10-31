package com.grassparty.tft.Model.DAO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "version_season")
public class VersionSeasonDAO {

    @Id
    private Long season_id;

    @Column
    private int season_version;
}
