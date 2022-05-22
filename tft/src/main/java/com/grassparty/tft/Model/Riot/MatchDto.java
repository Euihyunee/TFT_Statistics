package com.grassparty.tft.Model.Riot;

import com.grassparty.tft.Model.Riot.etc.InfoDto;
import com.grassparty.tft.Model.Riot.etc.MetadataDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// riot api DTO 받이, 그냥 object로 받으면 필요없을것같다는 생각이 들었음..
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDto {
    InfoDto info;
    MetadataDto metadata;
}
