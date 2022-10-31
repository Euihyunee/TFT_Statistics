package com.grassparty.tft.Model.DAO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stat_valid_record")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatValidRecordDAO {

    @Id
    private String matchID;
    
    // date 추가 예정

    @Column
    private Boolean valid;
}
