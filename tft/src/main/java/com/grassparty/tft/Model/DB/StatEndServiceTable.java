package com.grassparty.tft.Model.DB;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

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

}
