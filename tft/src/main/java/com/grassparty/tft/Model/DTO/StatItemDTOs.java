package com.grassparty.tft.Model.DTO;

import com.grassparty.tft.Model.DTO.subDTO.StatItemDTO;
import lombok.Data;

import java.util.List;

@Data
public class StatItemDTOs {
    String version;
    List<StatItemDTO> items;
}
