package com.grassparty.tft.Model.Riot;

import com.grassparty.tft.Model.Riot.etc.InfoDto;
import com.grassparty.tft.Model.Riot.etc.MetadataDto;
import lombok.Data;

// riot api DTO 받이, 그냥 object로 받으면 필요없을것같다는 생각이 들었음..
@Data
public class MatchDto {
    InfoDto info;
    MetadataDto metadata;
}
