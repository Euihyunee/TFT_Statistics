package com.grassparty.tft.Model.DAO;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "version")
public class VersionDAO {

    @Id
    private Long season_id;

    @Column
    private int season_version;
    @Column
    private int update_version;
    @Column
    private float total_version;
    
}
