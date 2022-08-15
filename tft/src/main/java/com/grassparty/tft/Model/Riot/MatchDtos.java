package com.grassparty.tft.Model.Riot;

import lombok.Data;

import java.util.ArrayList;

@Data
public class MatchDtos {
    ArrayList<MatchDto> matchDtos;

    public MatchDtos(){
        this.matchDtos = new ArrayList<MatchDto>();
    }

    public void PushMatchDto(MatchDto matchDto){
        this.matchDtos.add(matchDto);
    }
}

