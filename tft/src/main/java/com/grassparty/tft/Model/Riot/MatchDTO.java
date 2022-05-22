package com.grassparty.tft.Model.Riot;

import com.grassparty.tft.Model.Riot.etc.InfoDTO;
import com.grassparty.tft.Model.Riot.etc.MetadataDTO;
import lombok.Data;

// riot api DTO 받이, 그냥 object로 받으면 필요없을것같다는 생각이 들었음..
@Data
public class MatchDTO {
<<<<<<< HEAD
    MetadataDTO metadata;
    InfoDTO info;
=======
    InfoDTO info;
    MetadataDTO metadata;
>>>>>>> 600b34629d333935af687cd498800df2bc48d077
}
