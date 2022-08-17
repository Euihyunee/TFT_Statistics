package com.grassparty.tft.Model.DB;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_statendservice")
@Data
@EntityListeners(AuditingEntityListener.class)
public class StatEndServiceTable {
    @Id
    @Column
    private int serviceId;

    @Column
    @CreatedDate
    private LocalDateTime date;

    @OneToMany(mappedBy = "statEndServiceTable")
    private List<StatServiceTable> statServiceTables = new ArrayList<>();
}
