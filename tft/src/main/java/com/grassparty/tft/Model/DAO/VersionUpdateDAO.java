package com.grassparty.tft.Model.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="version_update")
public class VersionUpdateDAO {

    @Id
    private Long update_id;

    @Column
    private int season_id;

}
