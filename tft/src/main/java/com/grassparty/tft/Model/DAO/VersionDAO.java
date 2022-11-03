package com.grassparty.tft.Model.DAO;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "version")
@Getter @Setter
public class VersionDAO {


    @Id @GeneratedValue
    private Long gameVersionId;

    @Column
    private int seasonVersion;
    @Column
    private int updateVersion;
    @Column
    private String totalVersion;

}
