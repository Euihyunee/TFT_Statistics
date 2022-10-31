package com.grassparty.tft.Model.DAO;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="champion")
public class ChampionDAO {

    @Id
    private Long champion_id;

    @Column
    private String champion_name;
}
