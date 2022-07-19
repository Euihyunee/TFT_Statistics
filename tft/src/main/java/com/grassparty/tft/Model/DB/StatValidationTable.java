package com.grassparty.tft.Model.DB;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_statvalidation")
@Data
public class StatValidationTable {
    @Id
    @Column
    private String matchID;
    
    // date 추가 예정

    @Column
    private Boolean valid;
}
