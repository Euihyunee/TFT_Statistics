package com.grassparty.tft.Model.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserDAO {

    @Id
    private String puuid;

    @Column
    private String summoner_id;

    @Column
    private String user_name;
}
