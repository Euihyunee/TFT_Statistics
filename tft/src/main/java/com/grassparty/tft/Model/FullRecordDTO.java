package com.grassparty.tft.Model;

import com.grassparty.tft.Model.Riot.FullDTO.FullInfoDTO;
import com.grassparty.tft.Model.Riot.FullDTO.FullMetadataDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullRecordDTO {
    FullInfoDTO info;
    FullMetadataDTO metadata;
}
