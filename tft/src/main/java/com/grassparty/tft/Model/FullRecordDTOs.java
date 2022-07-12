package com.grassparty.tft.Model;

import lombok.Data;

@Data
public class FullRecordDTOs {
    FullRecordDTO[] fullRecordDTOs;

    public void add(FullRecordDTO fullRecordDTO){
        fullRecordDTOs[fullRecordDTOs.length] = fullRecordDTO;
    }
}
