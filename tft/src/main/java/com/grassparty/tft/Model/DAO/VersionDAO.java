package com.grassparty.tft.Model.DAO;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "version")
public class VersionDAO {

    @Id
    private Long versionId;

    @Column
    private int seasonVersion;
    @Column
    private int updateVersion;
    @Column
    private float totalVersion;

}
