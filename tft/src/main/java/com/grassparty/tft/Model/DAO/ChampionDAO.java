package com.grassparty.tft.Model.DAO;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="champion")
@Getter
public class ChampionDAO {

    @Id
    private String championId;

    @Column
    private String championName;
}
