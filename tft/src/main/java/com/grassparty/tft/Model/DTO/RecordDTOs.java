package com.grassparty.tft.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordDTOs {
    RecordDTO[] recordDTOS = new RecordDTO[10];
    int count=0;

    public void add(RecordDTO recordDTO){
        recordDTOS[count++] = recordDTO;
    }
}
