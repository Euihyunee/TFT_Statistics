package com.grassparty.tft.Model.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class ItemDAO {

    @Id
    private Long item_id;

    @Column
    private String item_name;
}
