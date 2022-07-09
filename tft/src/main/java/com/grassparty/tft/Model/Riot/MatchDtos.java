package com.grassparty.tft.Model.Riot;

import com.grassparty.tft.Model.FullRecordDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class MatchDtos {
    List<MatchDto> matchDtos;

    public MatchDtos(){
        this.matchDtos = new ArrayList<MatchDto>();
    }

    public void PushMatchDto(MatchDto matchDto){
        this.matchDtos.add(matchDto);
    }
}

