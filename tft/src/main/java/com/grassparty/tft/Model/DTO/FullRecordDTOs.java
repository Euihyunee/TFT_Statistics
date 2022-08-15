package com.grassparty.tft.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullRecordDTOs {
    FullRecordDTO[] fullRecordDTOs = new FullRecordDTO[10];
    int count=0;

    public void add(FullRecordDTO fullRecordDTO){
        fullRecordDTOs[count++] = fullRecordDTO;
    }
}
