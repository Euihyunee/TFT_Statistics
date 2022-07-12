package com.grassparty.tft.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullRecordDTOs {
    FullRecordDTO[] fullRecordDTOs = new FullRecordDTO[20];
    int count=0;

    public void add(FullRecordDTO fullRecordDTO){
        fullRecordDTOs[count++] = fullRecordDTO;
    }
}
