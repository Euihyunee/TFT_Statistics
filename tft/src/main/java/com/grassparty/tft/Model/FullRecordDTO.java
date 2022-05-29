package com.grassparty.tft.Model;

import com.grassparty.tft.Model.Riot.FullDTO.FullInfoDTO;
import com.grassparty.tft.Model.Riot.FullDTO.FullMetadataDTO;
import lombok.Data;

@Data
public class FullRecordDTO {
    FullInfoDTO info;
    FullMetadataDTO metadata;
}
