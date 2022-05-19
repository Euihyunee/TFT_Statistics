package com.grassparty.tft.Model.Riot;

import com.grassparty.tft.Model.Riot.etc.InfoDTO;
import com.grassparty.tft.Model.Riot.etc.MetadataDTO;
import lombok.Data;

// riot api DTO 받이
@Data
public class MatchDTO {
    InfoDTO infoDTO;
    MetadataDTO metadataDTO;
}
