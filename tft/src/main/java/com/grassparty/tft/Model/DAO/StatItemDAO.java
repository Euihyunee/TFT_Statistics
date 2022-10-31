package com.grassparty.tft.Model.DAO;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stat_item")
public class StatItemDAO {

    @Id
    private Long id;

    // 외래키(아이템)
    @Column
    private Long item_id;

    // 외래키(시즌 버전)
    @Column
    private int seasion_id;

    @Column
    private String item_name;

    @Column
    private Long count;

    @Column
    private Long sum_placement;
}
